package org.ioopm.calculator.ast;

/**
 * Represents a variable in a symbolic expression.
 *
 * <p>A variable is identified by its name and can be evaluated using an
 * {@link Environment}. If the environment contains a value associated with
 * the variable, evaluation returns that value. Otherwise, the variable
 * remains unevaluated.
 */
public class Variable extends Atom {
    private String id;

    /**
     * Creates a variable with the specified identifier.
     *
     * @param id the name of the variable
     */
    public Variable(String id) {
        this.id = id;
        super("Var");
    }

    /**
     * {@inheritDoc}
     *
     * <p>Returns the variable's identifier without any additional formatting.
     */
    @Override
    public String toString() {
        return id;
    }

    /**
     * {@inheritDoc}
     *
     * <p>Two variables are equal if they have the same identifier.
     */
    @Override
    public boolean equals(Object other) {
        if (other instanceof Variable) {
            return this.equals((Variable) other);
        } else {
            return false;
        }
    }

    /**
     * Checks whether another variable has the same identifier.
     *
     * @param other the variable to compare with
     * @return {@code true} if both variables have the same identifier,
     *         otherwise {@code false}
     */
    public boolean equals(Variable other) {
        /// access a private field of other!
        return this.id.equals(other.id);
    }

    /**
     * {@inheritDoc}
     *
     * <p>Looks up this variable in the supplied environment. If a value is
     * associated with the variable, that value is returned. Otherwise,
     * this variable is returned unchanged.
     */
    @Override
    public SymbolicExpression eval(Environment vars) {
        SymbolicExpression val = vars.get(this);
        if (val != null) {
            return val; //this Variable(this)
        } else {
            return this;
        }
    }

    /**
     * {@inheritDoc}
     *
     * <p>The hash code is derived from the variable's identifier.
     */
    @Override
    public int hashCode() {
        return this.id.hashCode();
    }
}