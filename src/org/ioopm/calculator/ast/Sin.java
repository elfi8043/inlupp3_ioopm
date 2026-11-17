package org.ioopm.calculator.ast;

public class Sin extends Unary {

    public Sin(SymbolicExpression arg) {
        super("sin", arg);
    }

    @Override 
    public String getName() {
        return "sin";
    }
}