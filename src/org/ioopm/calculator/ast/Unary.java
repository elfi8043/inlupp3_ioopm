package org.ioopm.calculator.ast;

public abstract class Unary extends SymbolicExpression {
    private SymbolicExpression arg;

    public Unary(SymbolicExpression arg)
    {
        this.arg = arg;
    }
}
