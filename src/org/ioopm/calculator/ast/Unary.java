
package org.ioopm.calculator.ast;

/**
 * Represents an abstract unary expression containing a single operand.
 *
 * <p>Unary expressions apply an operation to one symbolic expression.
 * Examples include negation and mathematical functions such as sine,
 * cosine, logarithm and exponential.
 *
 * <p>Subclasses define the specific operation and its evaluation
 * behaviour.
 */
public abstract class Unary extends SymbolicExpression {
    private SymbolicExpression arg;


    public Unary(String name, SymbolicExpression arg) {
        super(name, arg);
        this.arg = arg;
    }

/** {@inheritDoc} */
    @Override
    public String toString() {
        return this.getName() + " " + this.arg.toString();
    }

    /**
     * {@inheritDoc}
     *
     * <p>Two unary expressions are considered equal if they have the
     * same operation name and equal operands.
     */
    @Override
    public boolean equals(Object other) {
        if (other instanceof Unary) {
            return this.equals((Unary) other);
        } else {
            return false;
        }
    }

    /**
     * Compares this unary expression with another unary expression.
     *
     * <p>Equality is determined by comparing their operation names
     * and operands.
     *
     * @param other the unary expression to compare with
     * @return true if both expressions have the same operation and
     *         equal operands, otherwise false
     */
    public boolean equals(Unary other) {
        return this.getName().equals(other.getName())
            && this.arg.equals(other.arg);
    }

    /**
     * Returns the operand of this unary expression.
     *
     * @return the symbolic expression contained as the operand
     */
    public SymbolicExpression getArg() {
        return this.arg;
    }
}
