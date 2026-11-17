package org.ioopm.calculator.ast;

public abstract class Unary extends SymbolicExpression {
    private SymbolicExpression arg;

    public Unary(String name, SymbolicExpression arg)
    {
        super(name, arg);
        this.arg = arg;
    }

    public String toString() {
        /// Note how the call to toString() is not necessary
        return this.getName() + " " + this.arg.toString();
    }
}
