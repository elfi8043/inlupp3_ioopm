package org.ioopm.calculator.ast;

/**
 * Represents an atomic expression in the AST, such as a constant, variable or named constant.
 * The atom class serves the purpose of being a building block in the AST.
 */
public abstract class Atom extends SymbolicExpression{

    /**
     * Initializes an expression with the given name, such as {@link Variable} or {@link Constant}
     * @param name the string of the associated atom
     */
    public Atom(String name) {
        super(name);
    }
}
