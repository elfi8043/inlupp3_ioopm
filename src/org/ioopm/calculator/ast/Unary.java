package org.ioopm.calculator.ast;

public abstract class Unary extends SymbolicExpression {
    private String functionName;
    private SymbolicExpression arg;

    public Unary(SymbolicExpression arg)
    {
        this.arg = arg;
    }
}
