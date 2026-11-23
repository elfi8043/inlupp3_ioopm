package org.ioopm.calculator.ast;

/**
 * Represents a binary expression in the AST, combining the left-hand side and right-hand side
 * of the operation.
 * 
 */
public abstract class Binary extends SymbolicExpression {
    private SymbolicExpression lhs;
    private SymbolicExpression rhs;

    /**
     * Initializes a binary expression with the given name, as well as the two subexpressions.
     * 
     * @param name the name of the operator for the expression
     * @param lhs the left-hand side of the expression
     * @param rhs the right-hand side of the expression
     */
    public Binary(String name, SymbolicExpression lhs, SymbolicExpression rhs) {
        super(name, lhs, rhs);
        this.lhs = lhs;
        this.rhs = rhs;
    }

    /**
     * Creates a string representing the binary expression.
     * 
     * @return the string representing the expression
     * @see java.lang.Object#toString()
     */
    public String toString(){
        return lhs.toString() + " " + this.getName() + " " + rhs.toString();
    }

    /**
     * Replaces the equals method originally implemented for {@link Object},
     * making it specific for the {@code Binary} class. The method compares
     * one binary expression to another object and returns a boolean.
     * @see java.lang.Object#equals(java.lang.Object)
     * @param other the object for comparison
     * @return false if {@code other} is not a {@code Binary}, otherwise calls the second
     * {@code equals} method.
     */
    public boolean equals(Object other) {
        if (other instanceof Binary) {
            return this.equals((Binary) other);
        } else {
            return false;
        }
    }

    /**
     * Compares this binary expression with another {@code Binary}.
     * @param other the binary for comparison
     * @return true if both expressions have the same operator name and equal left and right operands.
     * Otherwise false.
     */
    public boolean equals(Binary other) {
        if (this.getName().equals(other.getName())) {
            if (this.lhs.equals(other.lhs) && (this.rhs.equals(other.rhs))) {
                return true;
            } else return false;
        } else {
            return false;
        }
    }

    /**
     * Returns the left-hand side of the expression.
     * @return the left-hand expression
     */
    public SymbolicExpression getLhs() {
        return lhs;
    }

    /**
     * Returns the right-hand side of the expression.
     * @return the right-hand expression
     */
    public SymbolicExpression getRhs() {
        return rhs;
    }
}   

