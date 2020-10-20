/*
 * (C) Copyright IBM Corp. 2016,2020
 *
 * SPDX-License-Identifier: Apache-2.0
 */

package com.ibm.fhir.provider.util;

import javax.ws.rs.core.MultivaluedMap;

import org.apache.cxf.jaxrs.impl.MetadataMap;
import org.apache.cxf.jaxrs.utils.JAXRSUtils;

/**
 * This class is used for parsing partial URL strings, specifically those
 * associated with bundled requests.
 */
public class FHIRUrlParser {
    private String path;
    private String query;
    private String[] pathTokens;
    private MultivaluedMap<String, String> queryParameters = new MetadataMap<>(false, true);

    /**
     * Hide the default constructor.
     */
    protected FHIRUrlParser() {
    }

    /**
     * constructor which accepts a partial URL string (e.g. <code>"Patient/123?param1=value1&amp;param2=value2"</code>).
     */
    public FHIRUrlParser(String urlString) {
        if (urlString == null) {
            throw new IllegalArgumentException("A null URL string is not allowed");
        }
        if (urlString.isEmpty()) {
            throw new IllegalArgumentException("An empty URL string is not allowed");
        }
        parse(urlString);
    }

    /**
     * Parses the url string into the path and query parts,
     * then parses the path part into the individual tokens and also parses the query string
     * into individual JAXRS-style parameters.
     * @param urlString
     */
    private void parse(String urlString) {
        String[] tokens = urlString.split("\\?");
        if (tokens.length > 0) {
            path = tokens[0];
            pathTokens = path.split("/");
        }
        if (tokens.length > 1) {
            query = tokens[1];
            if (query != null && !query.isEmpty()) {
                JAXRSUtils.getStructuredParams(queryParameters, query, "&", true, false);
            }
        }
    }

    public String getPath() {
        return path;
    }

    public String getQuery() {
        return query;
    }

    public String[] getPathTokens() {
        return pathTokens;
    }

    public MultivaluedMap<String, String> getQueryParameters() {
        return queryParameters;
    }

}