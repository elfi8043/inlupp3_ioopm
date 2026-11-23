package org.ioopm.calculator.ast;

import java.util.HashMap;
/**
 * NamedConstants
 * HashMap mapping String names of named constants to their values.
 */
public class NamedConstants {
    public static final HashMap<String, Double> namedConstants = new HashMap<>();

    static {
        NamedConstants.namedConstants.put("pi", Math.PI);
        NamedConstants.namedConstants.put("e",  Math.E);
        NamedConstants.namedConstants.put("Answer", 42.0);
        NamedConstants.namedConstants.put("L", 6.02214087 * Math.pow(10, 23));
    }
}