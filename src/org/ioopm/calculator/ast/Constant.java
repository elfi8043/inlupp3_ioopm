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
}   

