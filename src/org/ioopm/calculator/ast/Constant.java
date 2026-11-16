package org.ioopm.calculator.ast;

public class Constant extends Atom {
    private double value;
    public Constant(double num) {
        this.value = num;
        super("Const");
    }
}   

