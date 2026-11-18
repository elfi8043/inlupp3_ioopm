package org.ioopm.calculator.ast;

import java.util.HashMap;

public class Sin extends Unary {

    public Sin(SymbolicExpression arg) {
        super("sin", arg);
    }

    @Override 
    public String getName() {
        return "sin";
    }

    public SymbolicExpression eval(Environment vars) {
        SymbolicExpression arg = super.getArg().eval(vars);
        if (arg.isConstant()) {
            return new Constant(Math.sin(arg.getValue()));
        } else {
            return new Sin(arg);
        }
    }
}