package org.ioopm.calculator.ast;

import java.util.HashMap;

public class Exp extends Unary {

    public Exp(SymbolicExpression arg) {
        super("exp", arg);
    }

    @Override 
    public String getName() {
        return "exp";
    }

    @Override
    public SymbolicExpression eval(Environment vars) {
    SymbolicExpression arg = super.getArg().eval(vars);
    if (arg.isConstant()) {
        return new Constant(Math.exp(arg.getValue()));
    } else {
        return new Exp(arg);
    }
}
}

