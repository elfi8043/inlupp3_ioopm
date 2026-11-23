package org.ioopm.calculator.ast;

import java.util.HashMap;

import javax.management.RuntimeErrorException;

import org.ioopm.calculator.ast.SymbolicExpression;


/**
 * Represents an assignment expression in the AST.
 */
public class Assignment extends Binary {

    /**
     * Creates an assignment between two subexpressions.
     * @param lhs the left-hand side of the expression
     * @param rhs the right-hand side of the expression
     */
    public Assignment(SymbolicExpression lhs, SymbolicExpression rhs)
    {
        super("=", lhs, rhs);
    }

    /**
     * Evaluates both sides of the expression and assigns the value of the left-hand side
     * of the expression to the right. At least one side is required to have a {@link Variable}
     * for the assignment to be possible. A {@link NamedConstant} cannot be assigned to a new value.
     * @see org.ioopm.calculator.ast.SymbolicExpression#eval(org.ioopm.calculator.ast.Environment)
     * @param vars the variable environment used for evaluating variables.
     * @return the evaluated left-hand side of the expression.
     */
    public SymbolicExpression eval(Environment vars) {
        if (super.getRhs() instanceof Variable) {
            Variable rhs = (Variable) super.getRhs();

            SymbolicExpression value = super.getLhs().eval(vars);

            vars.put(rhs, value);

            return value;
        } else if (super.getRhs() instanceof NamedConstant) {
            throw new IllegalAssignmentException("Can't reassign a named variable.");
        } else {
            throw new IllegalAssignmentException("Can't assign to a non-variable.");
        }
    }
}
