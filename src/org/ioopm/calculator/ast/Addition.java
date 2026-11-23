package org.ioopm.calculator.ast;

import java.util.HashMap;

/**
 * Represents an addition expression in the AST.
 */
public class Addition extends Binary {

    /**
     * Creates an addition between two subexpressions.
     * @param lhs the left-hand side of the expression
     * @param rhs the right-hand side of the expression
     */
    public Addition(SymbolicExpression lhs, SymbolicExpression rhs)
    {
        super("+", lhs, rhs);
    }

    /**
     * A representation of addition as a string.
     * @see org.ioopm.calculator.ast.SymbolicExpression#getName()
     * @return {@code "+"}
     */
    @Override 
    public String getName() {
        return "+";
    }

    /**
     * Evaluates both operands in the environment and returns their sum. 
     * If either side cannot be reduced to a constant a new {@link Addition}
     * with new evaluated sides will be returned instead.
     * 
     * @see org.ioopm.calculator.ast.SymbolicExpression#eval(org.ioopm.calculator.ast.Environment)
     * @param vars the variable environment used for evaluating variables
     * @return a simplified {@link Addition} expression or a {@link Constant} if both sides of the expression evaluate to constants.
     */
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
