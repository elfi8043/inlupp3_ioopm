package org.ioopm.calculator.ast;

public abstract class Binary extends SymbolicExpression {
    private SymbolicExpression lhs = null;
    private SymbolicExpression rhs = null;

    public Binary(String name, SymbolicExpression lhs, SymbolicExpression rhs) {
        super(name, lhs, rhs);
    }
}