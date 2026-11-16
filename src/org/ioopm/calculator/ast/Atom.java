package org.ioopm.calculator.ast;

public abstract class Atom extends SymbolicExpression{

    public Atom(String name, Object... subExpressions)
    {
        super(name, subExpressions);
    }
}
