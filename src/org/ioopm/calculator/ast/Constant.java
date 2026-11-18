package org.ioopm.calculator.ast;

public class Constant extends Atom {
    private double value;

    public Constant(double num) {
        super("Const");
        this.value = num;
    }

    @Override 
    public boolean isConstant() {
        return true;
    }

    @Override 
    public double getValue() {
    return this.value;
    }

    public String toString() {
        return String.valueOf(this.value);
    }

    public boolean equals(Object other) {
        if (other instanceof Constant) {
            return this.equals((Constant) other);
        } else {
            return false;
        }
    }

    public boolean equals(Constant other) {
        /// access a private field of other!
        return this.value == other.value;
    }
}   

