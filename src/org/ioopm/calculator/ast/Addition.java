package org.ioopm.calculator.ast;

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
    public SymbolicExpression eval() {
        SymbolicExpression lhs = super.getLhs().eval();
        SymbolicExpression rhs = super.getRhs().eval();

        if (lhs.isConstant() && rhs.isConstant()) {
            return new Constant(lhs.getValue() + rhs.getValue());
        }

        else {
            return new Addition(lhs, rhs);
        }
    }
}
