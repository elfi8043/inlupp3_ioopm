package org.ioopm.calculator.ast;

import java.util.HashMap;

/**
 * Represents an exponential expression in the AST.
 */
public class Exp extends Unary {

    /**
     * Creates an exponential expression with the given subexpression.
     * 
     * @param arg the subexpression to be used
     */
    public Exp(SymbolicExpression arg) {
        super("exp", arg);
    }

    /**
     * Returns the name of the operator.
     * 
     * @see org.ioopm.calculator.ast.SymbolicExpression#getName()
     * @return {@code "exp"}
     */
    @Override 
    public String getName() {
        return "exp";
    }

    /**
     * Evaluates the operand.
     * If the evaluated operand is a {@link Constant}, a {@link Constant}
     * will be returned. Otherwise a new {@link Exp} expression will be returned.
     * 
     * @see org.ioopm.calculator.ast.SymbolicExpression#eval(org.ioopm.calculator.ast.Environment)
     * @return A {@link Constant} if the evaluated operand is a constants. Otherwise a {@link Exp}
     * expression.
     */
    @Override
    public SymbolicExpression eval(Environment vars) {
    SymbolicExpression arg = super.getArg().eval(vars);
    if (arg.isConstant()) {
        return new Constant(Math.exp(arg.getValue()));
    } else {
        return new Exp(arg);
    }
}
}

