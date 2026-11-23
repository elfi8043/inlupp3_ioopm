package org.ioopm.calculator.ast;

import java.util.HashMap;

/**
 * Represents the sin function of a symbolic expression.
 *
 * <p>Evaluates the sin function of its argument if the argument can be
 * reduced to a constant. Otherwise, returns a new Sin expression
 * containing the evaluated argument.
 *
 * <p>The sin is calculated using {@link Math#sin(double)},
 */

public class Sin extends Unary {

    public Sin(SymbolicExpression arg) {
        super("sin", arg);
    }

    /** {@inheritDoc} */
    @Override 
    public String getName() {
        return "sin";
    }
    /** {@inheritDoc} */
    public SymbolicExpression eval(Environment vars) {
        SymbolicExpression arg = super.getArg().eval(vars);
        if (arg.isConstant()) {
            return new Constant(Math.sin(arg.getValue()));
        } else {
            return new Sin(arg);
        }
    }
}