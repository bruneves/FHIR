/*
 * (C) Copyright IBM Corp. 2018,2019
 *
 * SPDX-License-Identifier: Apache-2.0
 */

package com.ibm.fhir.persistence.jdbc.util;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.ibm.fhir.persistence.exception.FHIRPersistenceException;
import com.ibm.fhir.persistence.jdbc.dao.api.ParameterNormalizedDAO;
import com.ibm.fhir.persistence.jdbc.dao.api.ResourceNormalizedDAO;
import com.ibm.fhir.search.parameters.InclusionParameter;

/**
 * This class assists the JDBCNormalizedQueryBuilder. It extends the QuerySegmentAggregator to build a FHIR Resource query
 * that processes _include and _revinclude search result parameters. Using the query segments built by the query builder, 
 * this class augments those query segments to result in a query that includes other resources as determined by 
 * InclusionParameter objects.
 * @author markd
 *
 */
public class InclusionQuerySegmentAggregator extends QuerySegmentAggregator {
    private static final String CLASSNAME = InclusionQuerySegmentAggregator.class.getName();
    private static final Logger log = java.util.logging.Logger.getLogger(CLASSNAME);
    
    
    private static final String SELECT_COUNT_ROOT = "SELECT COUNT(RESOURCE_ID) FROM ";
    private static final String SELECT_ROOT = "SELECT RESOURCE_ID, LOGICAL_RESOURCE_ID, VERSION_ID, LAST_UPDATED, IS_DELETED, DATA, LOGICAL_ID FROM ";
    private static final String UNION_ALL = " UNION ALL ";
    private static final String REVINCLUDE_JOIN = "JOIN  {0}_STR_VALUES P1 ON P1.LOGICAL_RESOURCE_ID = R.LOGICAL_RESOURCE_ID ";
        
    private List<InclusionParameter> includeParameters;
    private List<InclusionParameter> revIncludeParameters;

    
    protected InclusionQuerySegmentAggregator(Class<?> resourceType, int offset, int pageSize,
                                              ParameterNormalizedDAO parameterDao, ResourceNormalizedDAO resourceDao, 
                                              List<InclusionParameter> includeParameters, List<InclusionParameter> revIncludeParameters) {
        super(resourceType, offset, pageSize, parameterDao, resourceDao);
        this.includeParameters = includeParameters;
        this.revIncludeParameters = revIncludeParameters;
    }
    
    /**
     * This methods builds a query to return the count of resources matching the search. This count will encompass resources
     * represented by _include and _revinclude parameters. 
     * The following generated SQL is an example. It is based on this REST query string:
     * /Patient?id=some-id&_include=Patient:organization&_revinclude=Observation:patient
     * See comments embedded in the SQL for explanation:
     * 
       SELECT COUNT(RESOURCE_ID) FROM 
       -- The following SELECT is the query for the "target" Patient resource. It is generated by superclass methods.
           (SELECT R.RESOURCE_ID, R.LOGICAL_RESOURCE_ID, R.VERSION_ID, R.LAST_UPDATED, R.IS_DELETED, R.DATA, LR.LOGICAL_ID FROM 
          Patient_RESOURCES R JOIN 
          Patient_LOGICAL_RESOURCES LR ON R.LOGICAL_RESOURCE_ID=LR.LOGICAL_RESOURCE_ID JOIN 
          Patient_TOKEN_VALUES P1 ON P1.LOGICAL_RESOURCE_ID=LR.LOGICAL_RESOURCE_ID WHERE 
          R.IS_DELETED <> 'Y' AND 
          P1.RESOURCE_ID = R.RESOURCE_ID AND 
          (P1.PARAMETER_NAME_ID=1 AND ((P1.TOKEN_VALUE = ?))) 
       
       UNION ALL 
       
       -- The following part of the overall query is built by the processInlcudeParameters() method.
       -- The following SELECT is generated in order to retrieve the desired included Organization resources that are
       -- referenced by the target Patient resources.
       SELECT R.RESOURCE_ID, R.LOGICAL_RESOURCE_ID, R.VERSION_ID, R.LAST_UPDATED, R.IS_DELETED, R.DATA, LR.LOGICAL_ID FROM 
         Organization_RESOURCES R JOIN 
         Organization_LOGICAL_RESOURCES LR ON R.LOGICAL_RESOURCE_ID=LR.LOGICAL_RESOURCE_ID WHERE 
         R.IS_DELETED <> 'Y' AND 
         R.RESOURCE_ID = LR.CURRENT_RESOURCE_ID AND 
         ('Organization/' || LR.LOGICAL_ID IN 
           (SELECT P1.STR_VALUE FROM 
            Patient_STR_VALUES P1 WHERE 
            P1.PARAMETER_NAME_ID=19 AND 
            P1.RESOURCE_ID IN 
            (SELECT R.RESOURCE_ID FROM 
             Patient_RESOURCES R JOIN 
             Patient_LOGICAL_RESOURCES LR ON R.LOGICAL_RESOURCE_ID=LR.LOGICAL_RESOURCE_ID JOIN 
             Patient_TOKEN_VALUES P1 ON P1.LOGICAL_RESOURCE_ID=R.LOGICAL_RESOURCE_ID WHERE 
             R.IS_DELETED <> 'Y' AND 
             P1.RESOURCE_ID = R.RESOURCE_ID AND 
             (P1.PARAMETER_NAME_ID=1 AND ((P1.TOKEN_VALUE = ?)))
            )
           )
         ) 
         
         UNION ALL 

         -- The following part of the overall query is built by the processRevInlcudeParameters() method.
         -- The following SELECT is generated in order to retrieve the desired reverse included Observation resources 
         -- that reference the target Patient resources.
         SELECT R.RESOURCE_ID, R.LOGICAL_RESOURCE_ID, R.VERSION_ID, R.LAST_UPDATED, R.IS_DELETED, R.DATA, LR.LOGICAL_ID FROM 
          Observation_RESOURCES R JOIN 
          Observation_LOGICAL_RESOURCES LR ON R.LOGICAL_RESOURCE_ID=LR.LOGICAL_RESOURCE_ID JOIN  
          Observation_STR_VALUES P1 ON P1.RESOURCE_ID = R.RESOURCE_ID WHERE 
          R.IS_DELETED <> 'Y' AND 
          P1.PARAMETER_NAME_ID=29 AND 
          P1.STR_VALUE='Patient/' || 
           (SELECT LR.LOGICAL_ID FROM 
            Patient_RESOURCES R JOIN 
            Patient_LOGICAL_RESOURCES LR ON R.LOGICAL_RESOURCE_ID=LR.LOGICAL_RESOURCE_ID JOIN 
            Patient_TOKEN_VALUES P1 ON P1.RESOURCE_ID=R.RESOURCE_ID WHERE 
            R.IS_DELETED <> 'Y' AND 
            P1.RESOURCE_ID = R.RESOURCE_ID AND 
            (P1.PARAMETER_NAME_ID=1 AND ((P1.TOKEN_VALUE = ?)))
           )
         ) 
       COMBINED_RESULTS      
      * 
     */
    @Override
    protected SqlQueryData buildCountQuery() throws Exception {  
        final String METHODNAME = "buildCountQuery";
        log.entering(CLASSNAME, METHODNAME);
        
        StringBuilder queryString = new StringBuilder();
        SqlQueryData queryData;
        List<Object> allBindVariables = new ArrayList<>();
        
        this.addBindVariables(allBindVariables);
        
        queryString.append(SELECT_COUNT_ROOT);
        queryString.append("(");
        queryString.append(QuerySegmentAggregator.SELECT_ROOT);
        queryString.append(super.buildFromClause());
        queryString.append(super.buildWhereClause());
        
        this.processIncludeParameters(queryString, allBindVariables);
        this.processRevIncludeParameters(queryString, allBindVariables);
        
        queryString.append(")");    
        queryString.append(COMBINED_RESULTS);    
        
         
        queryData = new SqlQueryData(queryString.toString(), allBindVariables);
        log.exiting(CLASSNAME, METHODNAME);
        return queryData;
    }
    
    /**
     * This methods builds a query to return the resources which are the target of the search, along with other resources
     * specified by _include and rev_include parameters. The SQL generated by this method is the same as that generated
     * by the buildCountQuery() method with the following exceptions:
     * 1. The "root" SELECT selects individual columns instead of a COUNT.
     * 2. Pagination clauses are added to the end of the query.
     * @see The javadoc for the buildCountQuery() method for an example of the generated SQL along with a detailed
     * explanation.  
     */
    @Override
    protected SqlQueryData buildQuery() throws Exception { 
        final String METHODNAME = "buildQuery";
        log.entering(CLASSNAME, METHODNAME);
        
        StringBuilder queryString = new StringBuilder();
        SqlQueryData queryData;
        List<Object> allBindVariables = new ArrayList<>();
        
        this.addBindVariables(allBindVariables);
        
        queryString.append(InclusionQuerySegmentAggregator.SELECT_ROOT);
        queryString.append("(");
        queryString.append(QuerySegmentAggregator.SELECT_ROOT);
        queryString.append(super.buildFromClause());
        queryString.append(super.buildWhereClause());
        
        this.processIncludeParameters(queryString, allBindVariables);
        this.processRevIncludeParameters(queryString, allBindVariables);
        
        queryString.append(")");        
        queryString.append(COMBINED_RESULTS);    
        
        this.addPaginationClauses(queryString);
                 
        queryData = new SqlQueryData(queryString.toString(), allBindVariables);
        log.exiting(CLASSNAME, METHODNAME);
        return queryData;
    }
    
    private void processIncludeParameters(StringBuilder queryString, List<Object> bindVariables) throws Exception {
        final String METHODNAME = "processIncludeParameters";
        log.entering(CLASSNAME, METHODNAME);
        
        for (InclusionParameter includeParm : this.includeParameters) {
            // UNION ALL
            queryString.append(UNION_ALL);
            // SELECT R.RESOURCE_ID, R.LOGICAL_RESOURCE_ID, R.VERSION_ID, R.LAST_UPDATED, R.IS_DELETED, R.DATA, LR.LOGICAL_ID 
            queryString.append(QuerySegmentAggregator.SELECT_ROOT);
            // FROM Organization_RESOURCES R JOIN Organization_LOGICAL_RESOURCES LR ON R.LOGICAL_RESOURCE_ID=LR.LOGICAL_RESOURCE_ID
            queryString.append(MessageFormat.format(QuerySegmentAggregator.FROM_CLAUSE_ROOT, includeParm.getSearchParameterTargetType()));
            // WHERE R.IS_DELETED <> 'Y' AND
            queryString.append(QuerySegmentAggregator.WHERE_CLAUSE_ROOT).append(" AND ");
            // R.RESOURCE_ID = LR.CURRENT_RESOURCE_ID AND
            queryString.append("R.RESOURCE_ID = LR.CURRENT_RESOURCE_ID AND ");
            // ('Organization/' || LR.LOGICAL_ID IN 
            queryString.append("('").append(includeParm.getSearchParameterTargetType()).append("/' || LR.LOGICAL_ID IN ");
            // (SELECT P1.STR_VALUE FROM OBSERVATION_STR_VALUES P1 WHERE
            queryString.append("(SELECT P1.STR_VALUE FROM ").append(this.resourceType.getSimpleName()).append("_STR_VALUES P1 WHERE ");
            // P1.PARAMETER_NAME_ID=xx AND 
            queryString.append("P1.PARAMETER_NAME_ID=").append(this.getParameterNameId(includeParm.getSearchParameter())).append(" AND ");
            // P1.RESOURCE_ID IN 
            queryString.append("P1.LOGICAL_RESOURCE_ID IN ");
            // (SELECT R.LOGICAL_RESOURCE_ID  
            queryString.append("(SELECT R.LOGICAL_RESOURCE_ID ");
            // Add FROM clause for "root" resource type
            queryString.append(super.buildFromClause());
            // Add WHERE clause for "root" resource type
            queryString.append(super.buildWhereClause());
            
            queryString.append(")))");
                        
            this.addBindVariables(bindVariables);
        }
        log.exiting(CLASSNAME, METHODNAME);
    }
    
    private void processRevIncludeParameters(StringBuilder queryString, List<Object> bindVariables) throws Exception { 
        final String METHODNAME = "processRevIncludeParameters";
        log.entering(CLASSNAME, METHODNAME);
        
        for (InclusionParameter includeParm : this.revIncludeParameters) {
            // UNION ALL
            queryString.append(UNION_ALL);
            // SELECT R.RESOURCE_ID, R.LOGICAL_RESOURCE_ID, R.VERSION_ID, R.LAST_UPDATED, R.IS_DELETED, R.DATA, LR.LOGICAL_ID 
            queryString.append(QuerySegmentAggregator.SELECT_ROOT);
            // FROM Observation_RESOURCES R JOIN Observation_LOGICAL_RESOURCES LR ON R.LOGICAL_RESOURCE_ID=LR.LOGICAL_RESOURCE_ID
            queryString.append(MessageFormat.format(QuerySegmentAggregator.FROM_CLAUSE_ROOT, includeParm.getJoinResourceType()));
            // JOIN Observation_STR_VALUES P1 ON P1.RESOURCE_ID = R.RESOURCE_ID
            queryString.append(MessageFormat.format(REVINCLUDE_JOIN, includeParm.getJoinResourceType()));
            // WHERE R.IS_DELETED <> 'Y' AND
            queryString.append(QuerySegmentAggregator.WHERE_CLAUSE_ROOT).append(" AND ");
            // P1.PARAMETER_NAME_ID=xx AND 
            queryString.append("P1.PARAMETER_NAME_ID=").append(this.getParameterNameId(includeParm.getSearchParameter())).append(" AND ");
            // P1.STR_VALUE='Patient/'  ||
            queryString.append("P1.STR_VALUE='").append(includeParm.getSearchParameterTargetType()).append("/' || ");
            // (SELECT LR.LOGICAL_ID
            queryString.append("(SELECT LR.LOGICAL_ID ");
            // Add FROM clause for "root" resource type
            queryString.append(super.buildFromClause());
            // Add WHERE clause for "root" resource type
            queryString.append(super.buildWhereClause());
            
            queryString.append(")");
                        
            this.addBindVariables(bindVariables);
        }
        log.exiting(CLASSNAME, METHODNAME);
    }
    
    /**
     * Returns the integer id that corresponds to the passed search parameter name.
     * @param searchParameterName
     * @return Integer
     * @throws FHIRPersistenceException
     */
    private Integer getParameterNameId(String searchParameterName) throws FHIRPersistenceException {
        final String METHODNAME = "getParameterNameId";
        log.entering(CLASSNAME, METHODNAME);
        
        Integer parameterNameId;
        
        parameterNameId = ParameterNamesCache.getParameterNameId(searchParameterName);
        if (parameterNameId == null) {
            parameterNameId = this.parameterDao.readParameterNameId(searchParameterName);
            if (parameterNameId != null) {
                this.parameterDao.addParameterNamesCacheCandidate(searchParameterName, parameterNameId);
            }
            else {
                parameterNameId = -1; // need a value to keep query syntax valid
            }
        }
        
        log.exiting(CLASSNAME, METHODNAME);
        return parameterNameId;
        
    }
    
    /**
     * Adds the bind variables contained in all of the query segments contained in this instance to the passed collection.
     * @param bindVariables
     */
    private void addBindVariables(List<Object> bindVariables) {
        final String METHODNAME = "addBindVariables";
        log.entering(CLASSNAME, METHODNAME);
        
        for (SqlQueryData querySegment : this.querySegments) {
            bindVariables.addAll(querySegment.getBindVariables());
        }
        log.exiting(CLASSNAME, METHODNAME);
    }

}
