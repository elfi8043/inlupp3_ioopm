package org.ioopm.calculator.ast;

import java.util.HashMap;

/**
 * Represents a division expression in the AST.
 */
public class Division extends Binary {
    /**
     * Creates a divison expression from two subexpressions.
     * 
     * @param lhs the dividend subexpression
     * @param rhs the divisor subexpression
     */
    public Division(SymbolicExpression lhs, SymbolicExpression rhs) {
        super("/", lhs, rhs);
    }

    /**
     * Returns the symbol representing division
     * @see org.ioopm.calculator.ast.SymbolicExpression#getName()
     * @return a string of the symbol
     */
    @Override 
    public String getName() {
        return "/";
    }

    /**
     * Represents the priority of division when evaluating an expression.
     * @see org.ioopm.calculator.ast.SymbolicExpression#getPriority()
     * @return {@code 100}
     */
    @Override 
    public int getPriority() {
        return 100;
    }

    /**
     * Evaluates both operands.
     * If both operands are {@link Constant} a {@link Constant} is returned containing
     * the operands evaluated value after division. Otherwise a new {@link Division}
     * expression is returned with the evaluated operands.
     * 
     * @see org.ioopm.calculator.ast.SymbolicExpression#eval(org.ioopm.calculator.ast.Environment)
     * @return A {@link Constant} if both operands are constants. Otherwise a {@link Division}
     * expression.
     */
    @Override
    public SymbolicExpression eval(Environment vars) {
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