package org.ioopm.calculator.ast;

public class Exp extends Unary {

    public Exp(SymbolicExpression arg) {
        super("exp", arg);
    }

    @Override 
    public String getName() {
        return "exp";
    }

    @Override
    public SymbolicExpression eval() {
    SymbolicExpression arg = super.getArg().eval();
    if (arg.isConstant()) {
        return new Constant(Math.exp(arg.getValue()));
    } else {
        return new Exp(arg);
    }
}
}

