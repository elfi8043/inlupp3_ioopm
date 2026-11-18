package org.ioopm.calculator.ast;

public class Sin extends Unary {

    public Sin(SymbolicExpression arg) {
        super("sin", arg);
    }

    @Override 
    public String getName() {
        return "sin";
    }

    public SymbolicExpression eval() {
        SymbolicExpression arg = super.getArg().eval();
        if (arg.isConstant()) {
            return new Constant(Math.sin(arg.getValue()));
        } else {
            return new Sin(arg);
        }
    }
}