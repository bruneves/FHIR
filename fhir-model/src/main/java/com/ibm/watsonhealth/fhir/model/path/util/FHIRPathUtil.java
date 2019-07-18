/**
 * (C) Copyright IBM Corp. 2019
 *
 * SPDX-License-Identifier: Apache-2.0
 */

package com.ibm.watsonhealth.fhir.model.path.util;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;

import java.math.BigDecimal;
import java.time.temporal.TemporalAccessor;
import java.util.Collection;
import java.util.List;

import com.ibm.watsonhealth.fhir.model.path.FHIRPathBooleanValue;
import com.ibm.watsonhealth.fhir.model.path.FHIRPathIntegerValue;
import com.ibm.watsonhealth.fhir.model.path.FHIRPathNode;
import com.ibm.watsonhealth.fhir.model.path.FHIRPathPrimitiveValue;
import com.ibm.watsonhealth.fhir.model.path.FHIRPathStringValue;
import com.ibm.watsonhealth.fhir.model.path.evaluator.FHIRPathEvaluator;
import com.ibm.watsonhealth.fhir.model.path.exception.FHIRPathException;

public final class FHIRPathUtil {
    private FHIRPathUtil() { }

    public static Collection<FHIRPathNode> eval(String expr) throws FHIRPathException {
        return eval(expr, empty());
    }
    
    public static Collection<FHIRPathNode> eval(String expr, FHIRPathNode node) throws FHIRPathException {
        return eval(expr, singleton(node));
    }

    public static Collection<FHIRPathNode> eval(String expr, Collection<FHIRPathNode> initialContext) throws FHIRPathException {
        return FHIRPathEvaluator.evaluator(expr).evaluate(initialContext);
    }
    
    public static BigDecimal getDecimal(Collection<FHIRPathNode> nodes) {
        return getPrimitiveValue(nodes).asNumberValue().asDecimalValue().decimal();
    }
    
    public static Integer getInteger(Collection<FHIRPathNode> nodes) {
        return getPrimitiveValue(nodes).asNumberValue().asIntegerValue().integer();
    }
    
    public static String getString(Collection<FHIRPathNode> nodes) {
        return getPrimitiveValue(nodes).asStringValue().string();
    }
    
    public static Boolean getBoolean(Collection<FHIRPathNode> nodes) {
        return getPrimitiveValue(nodes).asBooleanValue()._boolean();
    }
    
    public static TemporalAccessor getDateTime(Collection<FHIRPathNode> nodes) {
        return getPrimitiveValue(nodes).asDateTimeValue().dateTime();
    }
    
    public static TemporalAccessor getTime(Collection<FHIRPathNode> nodes) {
        return getPrimitiveValue(nodes).asTimeValue().time();
    }
    
    public static boolean hasPrimitiveValue(Collection<FHIRPathNode> nodes) {
        if (isSingleton(nodes)) {
            FHIRPathNode node = getSingleton(nodes);
            if (node.isPrimitiveValue()) {
                return true;
            }
            if (node.isElementNode()) {
                return node.asElementNode().hasValue();
            }
        }
        return false;
    }
    
    public static FHIRPathPrimitiveValue getPrimitiveValue(Collection<FHIRPathNode> nodes) {
        if (!isSingleton(nodes)) {
            throw new IllegalArgumentException();
        }
        FHIRPathNode node = getSingleton(nodes);
        if (node.isPrimitiveValue()) {
            return node.asPrimitiveValue();
        }
        if (node.isElementNode() && node.asElementNode().hasValue()) {
            return node.asElementNode().getValue();
        }
        throw new IllegalArgumentException();
    }
    
    public static FHIRPathStringValue getStringValue(Collection<FHIRPathNode> nodes) {
        return getPrimitiveValue(nodes).asStringValue();
    }
    
    public static FHIRPathIntegerValue getIntegerValue(Collection<FHIRPathNode> nodes) {
        return getPrimitiveValue(nodes).asNumberValue().asIntegerValue();
    }
    
    public static FHIRPathBooleanValue getBooleanValue(Collection<FHIRPathNode> nodes) {
        return getPrimitiveValue(nodes).asBooleanValue();
    }
    
    public static boolean hasBooleanValue(Collection<FHIRPathNode> nodes) {
        return hasPrimitiveValue(nodes) && getPrimitiveValue(nodes).isBooleanValue();
    }
    
    public static boolean isTrue(Collection<FHIRPathNode> nodes) {
        return getBooleanValue(nodes).isTrue();
    }
    
    public static boolean isFalse(Collection<FHIRPathNode> nodes) {
        return getBooleanValue(nodes).isFalse();
    }

    public static boolean isSingleton(Collection<FHIRPathNode> nodes) {
        return nodes.size() == 1;
    }

    public static FHIRPathNode getSingleton(Collection<FHIRPathNode> nodes) {
        if (!isSingleton(nodes)) {
            throw new IllegalArgumentException();
        }
        if (nodes instanceof List) {
            List<?> list = (List<?>) nodes;
            return (FHIRPathNode) list.get(0);
        }
        return nodes.iterator().next();
    }
    
    public static Collection<FHIRPathNode> singleton(FHIRPathNode node) {
        return singletonList(node);
    }
    
    public static Collection<FHIRPathNode> empty() {
        return emptyList();
    }
}
