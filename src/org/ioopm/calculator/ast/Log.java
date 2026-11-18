package org.ioopm.calculator.ast;

import java.util.HashMap;

public class Log extends Unary {
    public Log(SymbolicExpression arg) {
        super("log", arg);
    }
     
    @Override 
    public String getName() {
        return "log";
    }

    public SymbolicExpression eval(HashMap<Variable, SymbolicExpression> vars) {
        SymbolicExpression arg = super.getArg().eval(vars);
        if (arg.isConstant()) {
            return new Constant(Math.log(arg.getValue()));
        } else {
            return new Log(arg);
        }
    }
}