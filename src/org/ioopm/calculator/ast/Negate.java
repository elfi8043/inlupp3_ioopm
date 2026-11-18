package org.ioopm.calculator.ast;

public abstract class Negate extends Unary {
    public Negate(SymbolicExpression arg) {
        super("neg", arg);
    }

    @Override 
    public String getName() {
        return "neg";
    }

    public SymbolicExpression eval() {
        SymbolicExpression arg = super.getArg().eval();
        if (arg.isConstant()) {
            return new Constant(0 - (arg.getValue()));
        } else {
            return new Negate(arg);
        }
    }
}
