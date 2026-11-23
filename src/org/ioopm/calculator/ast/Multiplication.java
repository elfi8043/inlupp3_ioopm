package org.ioopm.calculator.ast;

import java.util.HashMap;

/**
 * Represents a multiplication operation between two symbolic expressions.
 *
 * <p>Evaluates both operands and calculates their product if both
 * can be reduced to constants. Otherwise, returns a new Multiplication
 * expression containing the evaluated operands.
 */

public class Multiplication extends Binary {
    public Multiplication(SymbolicExpression lhs, SymbolicExpression rhs)
    {
        super("*", lhs, rhs);
    }

    /** {@inheritDoc} */
    @Override 
    public String getName() {
        return "*";
    }

    /** {@inheritDoc} */
    @Override 
    public int getPriority() {
        return 100;
    }

    /** {@inheritDoc} */
    @Override
    public SymbolicExpression eval(Environment vars) {
        SymbolicExpression lhs = super.getLhs().eval(vars);
        SymbolicExpression rhs = super.getRhs().eval(vars);

        if (lhs.isConstant() && rhs.isConstant()) {
            return new Constant(lhs.getValue() * rhs.getValue());
        }

        else {
            return new Multiplication(lhs, rhs);
        }
    }
}
