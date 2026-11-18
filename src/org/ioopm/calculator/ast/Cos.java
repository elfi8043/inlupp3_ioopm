package org.ioopm.calculator.ast;

import java.util.HashMap;

public class Cos extends Unary {
    public Cos(SymbolicExpression arg) {
        super("Cos", arg);
    }

    @Override 
    public String getName() {
        return "cos";
    }

    public SymbolicExpression eval(HashMap<Variable, SymbolicExpression> vars) {
        SymbolicExpression arg = super.getArg().eval(vars);
        if (arg.isConstant()) {
            return new Constant(Math.cos(arg.getValue()));
        } else {
            return new Cos(arg);
        }
    }
}