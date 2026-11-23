package org.ioopm.calculator.ast;

public class NamedConstant extends Atom{
    private double val;
    private String name;

    /**
    * Represents a named mathematical constant with an associated numerical value.
    *
    * <p>Examples include pi and e. A NamedConstant evaluates to a Constant
    * containing its stored numerical value.
    */

    public NamedConstant(String name, double val) {
        super(name);
        this.val = val;
        this.name = name;
    }

    /** {@inheritDoc} */
    @Override 
    public SymbolicExpression eval(Environment vars)
    {
        return new Constant(this.val);
    }
    /** {@inheritDoc} */
    @Override
    public String getName() {
        return this.name;
    }
    /** {@inheritDoc} */
    public boolean equals(Object other) {
        if (other instanceof NamedConstant) {
            return this.equals((NamedConstant) other);
        } else {
            return false;
        }
    }

    public boolean equals(NamedConstant other) {
        /// access a private field of other!
        if (this.val == other.val && this.getName().equals(other.getName())) { // ELIS WAS HERE
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public int hashCode()
    {
        return this.name.hashCode();
    }
    
}
