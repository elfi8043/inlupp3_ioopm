package org.ioopm.calculator.ast;

public abstract class Negate extends Unary {
    public Negate(String name, SymbolicExpression arg) {
        super(name, arg);
    }
}
