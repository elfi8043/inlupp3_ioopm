package org.ioopm.calculator.ast;

public abstract class Unary extends SymbolicExpression {
    private SymbolicExpression arg;

    public Unary(String name, SymbolicExpression arg)
    {
        super(name, arg);
    }
}
