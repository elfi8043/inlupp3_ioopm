package org.ioopm.calculator.ast;
import java.util.HashMap;

/**
 * Represents a variable environment mapping {@link Variable} to 
 * {@link SymbolicExpression} to be used during evaluation.
 * 
 */
public class Environment extends HashMap<Variable, SymbolicExpression> {} 