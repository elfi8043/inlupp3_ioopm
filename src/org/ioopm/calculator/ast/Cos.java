package org.ioopm.calculator.ast;

import java.util.HashMap;

/**
 * Represents Cos in the AST tree.
 */
public class Cos extends Unary {
    /**
     * Creats a cos expression with the given subexpression.
     * 
     * @param arg the subexpression to be used
     */
    public Cos(SymbolicExpression arg) {
        super("Cos", arg);
    }

    /**
     * Provides the operator name for the expression.
     * 
     * @see org.ioopm.calculator.ast.SymbolicExpression#getName()
     * @return {@code "cos"}
     */
    @Override 
    public String getName() {
        return "cos";
    }

    /**
     * Evaluates the operand and returns {@link Constant} if the evaluated operand is a constant,
     * otherwise a new {@link Cos} with the evaluated operand.
     * 
     * @see org.ioopm.calculator.ast.SymbolicExpression#eval(org.ioopm.calculator.ast.Environment)
     * @param vars the variable environment used for evaluating variables.
     * @return a {@link Constant} with the new evaluated value or another {@link Cos} expression
     * if the expression does not get evaluated to a constant.
     */
    public SymbolicExpression eval(Environment vars) {
        SymbolicExpression arg = super.getArg().eval(vars);
        if (arg.isConstant()) {
            return new Constant(Math.cos(arg.getValue()));
        } else {
            return new Cos(arg);
        }
    }
}