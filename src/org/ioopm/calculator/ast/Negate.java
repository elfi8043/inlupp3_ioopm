package org.ioopm.calculator.ast;

import java.util.HashMap;

public abstract class Negate extends Unary {
    public Negate(SymbolicExpression arg) {
        super("neg", arg);
    }

    @Override 
    public String getName() {
        return "neg";
    }

    public SymbolicExpression eval(HashMap<Variable, SymbolicExpression> vars) {
        SymbolicExpression arg = super.getArg().eval(vars);
        if (arg.isConstant()) {
            return new Constant(0 - (arg.getValue()));
        } else {
            return new Negate(arg);
        }
    }
}
