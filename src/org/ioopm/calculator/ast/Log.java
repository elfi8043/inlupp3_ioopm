package org.ioopm.calculator.ast;

import java.util.HashMap;

/**
 * Represents a natural logarithm expression in the AST.
 */
public class Log extends Unary {
    /**
     * Creates a logarithm expression with the given subexpression.
     * 
     * @param arg the subexpression to be provided
     */
    public Log(SymbolicExpression arg) {
        super("log", arg);
    }
     
    /**
     * Gets the name of the operator.
     * 
     * @see org.ioopm.calculator.ast.SymbolicExpression#getName()
     * @return {@code "log"}
     */
    @Override 
    public String getName() {
        return "log";
    }

    /**
     * Evaluates the operand and returns a {@link Constant} if the
     * evaluated operand is a constant, otherwise returns a new {@link Log}
     * with the evaluated operand as the subexpression.
     * 
     * @see org.ioopm.calculator.ast.SymbolicExpression#eval(org.ioopm.calculator.ast.Environment)
     * @param vars the variable environment
     * @return A {@link Constant} with the evaluated operand using Math.log if the
     * operand is a {@link Constant}. Otherwise a new {@link Log} expression.
     */
    public SymbolicExpression eval(Environment vars) {
        SymbolicExpression arg = super.getArg().eval(vars);
        if (arg.isConstant()) {
            return new Constant(Math.log(arg.getValue()));
        } else {
            return new Log(arg);
        }
    }
}