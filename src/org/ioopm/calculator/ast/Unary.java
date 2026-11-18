package org.ioopm.calculator.ast;

public abstract class Unary extends SymbolicExpression {
    private SymbolicExpression arg;

    public Unary(String name, SymbolicExpression arg)
    {
        super(name, arg);
        this.arg = arg;
    }

    public String toString() {
        /// Note how the call to toString() is not necessary
        return this.getName() + " " + this.arg.toString();
    }

    public boolean equals(Object other) {
        if (other instanceof Unary) {
            return this.equals((Unary) other);
        } else {
            return false;
        }
    }

    public boolean equals(Unary other) {
    /// access a private field of other!
        if (this.getName().equals(other.getName()) && this.arg.equals(other.arg)){
            return true;
        }

        else {
            return false;
        }
    }
}
