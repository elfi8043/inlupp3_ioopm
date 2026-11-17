package org.ioopm.calculator.ast;

public class Exp extends Unary {

    public Exp(SymbolicExpression arg) {
        super("exp", arg);
    }

    @Override 
    public String getName() {
        return "exp";
    }
}

