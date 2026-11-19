package org.ioopm.calculator.ast;

public class NamedConstant extends Atom{
    private double val;
    private String name;

    public NamedConstant(String name, double val) {
        super(name);
        this.val = val;
        this.name = name;
    }

    @Override 
    public SymbolicExpression eval(Environment vars)
    {
        return new Constant(this.val);
    }

    @Override
    public String getName() {
        return this.name;
    }

    public boolean equals(Object other) {
        if (other instanceof NamedConstant) {
            return this.equals((NamedConstant) other);
        } else {
            return false;
        }
    }

    public boolean equals(NamedConstant other) {
        /// access a private field of other!
        if (this.val == other.val && this.getName() == other.getName()) {
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
