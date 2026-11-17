package org.ioopm.calculator.ast;

public abstract class Negate extends Unary {
    public Negate(SymbolicExpression arg) {
        super("neg", arg);
    }

    @Override 
    public String getName() {
        return "neg";
    }
}
