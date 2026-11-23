package org.ioopm.calculator.ast;

import java.util.HashMap;

/**
 * Represents the natural logarithm of a symbolic expression.
 *
 * <p>Evaluates the logarithm of its argument if the argument can be
 * reduced to a constant. Otherwise, returns a new Log expression
 * containing the evaluated argument.
 *
 * <p>The logarithm is calculated using {@link Math#log(double)},
 * which computes the natural logarithm (base e).
 */

public class Log extends Unary {
    public Log(SymbolicExpression arg) {
        super("log", arg);
    }
     
    @Override 
    /** {@inheritDoc} */
    public String getName() {
        return "log";
    }

    /** {@inheritDoc} */
    public SymbolicExpression eval(Environment vars) {
        SymbolicExpression arg = super.getArg().eval(vars);
        if (arg.isConstant()) {
            return new Constant(Math.log(arg.getValue()));
        } else {
            return new Log(arg);
        }
    }
}