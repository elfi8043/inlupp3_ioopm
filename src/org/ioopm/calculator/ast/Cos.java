package org.ioopm.calculator.ast;

public class Cos extends Unary {
    public Cos(SymbolicExpression arg) {
        super("Cos", arg);
    }

    @Override 
    public String getName() {
        return "cos";
    }

    public SymbolicExpression eval() {
        SymbolicExpression arg = super.getArg().eval();
        if (arg.isConstant()) {
            return new Constant(Math.cos(arg.getValue()));
        } else {
            return new Cos(arg);
        }
    }
}