package org.ioopm.calculator.ast;

import java.util.HashMap;

/**
 * Represents the negation of a symbolic expression.
 *
 * <p>Evaluates its argument and negates its value if it can be reduced
 * to a constant. Otherwise, returns a new Negate expression containing
 * the evaluated argument.
 */

public class Negate extends Unary {
    public Negate(SymbolicExpression arg) {
        super("neg", arg);
    }

    /** {@inheritDoc} */
    @Override 
    public String getName() {
        return "neg";
    }

    /** {@inheritDoc} 
     * If the argument can be reduced to a constant it returns 0-(arg)
    */
    public SymbolicExpression eval(Environment vars) {
        SymbolicExpression arg = super.getArg().eval(vars);
        if (arg.isConstant()) {
            return new Constant(0 - (arg.getValue()));
        } else {
            return new Negate(arg);
        }
    }
}
