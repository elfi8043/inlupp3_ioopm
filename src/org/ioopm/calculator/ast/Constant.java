package org.ioopm.calculator.ast;

import java.util.HashMap;

/**
 * Represents a constant in the AST.
 */
public class Constant extends Atom {
    private double value;

    /**
     * Creates a constant expression containing the provided value.
     * @param num the value of the constant.
     */
    public Constant(double num) {
        super("Const");
        this.value = num;
    }

    /**
     * Indicates that the expression is a constant
     * 
     * @see org.ioopm.calculator.ast.SymbolicExpression#isConstant()
     * @return true
     */
    public boolean isConstant() {
        return true;
    }

    /**
     * Provides the value of the constant.
     * 
     * @see org.ioopm.calculator.ast.SymbolicExpression#getValue()
     * @return the value of the constant.
     */
    public double getValue() {
        return this.value;
    }

    /**
     * Returns a string representing the constant's value.
     * 
     * @see java.lang.Object#toString()
     * @return the string of the value.
     */
    public String toString() {
        return String.valueOf(this.value);
    }

    /**
     * Replaces the equals method originally implemented for {@link Object},
     * making it specific for the {@code Constant} class. The method compares
     * one constant to another object and returns a boolean.
     * @see java.lang.Object#equals(java.lang.Object)
     * @param other the object for comparison
     * @return false if {@code other} is not a {@code Constant}, otherwise calls the second
     * {@code equals} method.
     */
    public boolean equals(Object other) {
        if (other instanceof Constant) {
            return this.equals((Constant) other);
        } else {
            return false;
        }
    }

    /**
     * Compares this constant with another {@code Constant}.
     * @param other the constant for comparison
     * @return true if both expressions have the same value.
     * Otherwise false.
     */
    public boolean equals(Constant other) {
        /// access a private field of other!
        return this.value == other.value;
    }


    /**
     * Evaluates the constant by returning its value.
     * 
     * @see org.ioopm.calculator.ast.SymbolicExpression#eval(org.ioopm.calculator.ast.Environment)
     * @param vars the variable environment used for evaluating variables.
     * @return the value of the constant
     */
    public SymbolicExpression eval(Environment vars) {
        return this;
    }
}   

