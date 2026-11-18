package org.ioopm.calculator.ast;

import java.util.HashMap;

public class Division extends Binary {
    public Division(SymbolicExpression lhs, SymbolicExpression rhs) {
        super("/", lhs, rhs);
    }

    @Override 
    public String getName() {
        return "/";
    }

    @Override 
    public int getPriority() {
        return 100;
    }

    @Override
    public SymbolicExpression eval(HashMap<Variable, SymbolicExpression> vars) {
        SymbolicExpression lhs = super.getLhs().eval(vars);
        SymbolicExpression rhs = super.getRhs().eval(vars);

        if (lhs.isConstant() && rhs.isConstant()) {
            return new Constant(lhs.getValue() / rhs.getValue());
        }

        else {
            return new Division(lhs, rhs);
        }
    }
}