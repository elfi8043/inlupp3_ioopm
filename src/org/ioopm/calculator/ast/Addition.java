package org.ioopm.calculator.ast;

import java.util.HashMap;

public class Addition extends Binary {
    public Addition(SymbolicExpression lhs, SymbolicExpression rhs)
    {
        super("+", lhs, rhs);
    }

    @Override 
    public String getName() {
        return "+";
    }

    @Override
    public SymbolicExpression eval(Environment vars) {
        SymbolicExpression lhs = super.getLhs().eval(vars);
        SymbolicExpression rhs = super.getRhs().eval(vars);

        if (lhs.isConstant() && rhs.isConstant()) {
            return new Constant(lhs.getValue() + rhs.getValue());
        }

        else {
            return new Addition(lhs, rhs);
        }
    }
}
