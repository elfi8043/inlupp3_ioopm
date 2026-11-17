package org.ioopm.calculator.ast;

public class Constant extends Atom {
    private double value;

    public Constant(double num) {
        super("Const");
        this.value = num;
    }

    @Override 
    public bool isConstant() {
        return true;
    }
}   

