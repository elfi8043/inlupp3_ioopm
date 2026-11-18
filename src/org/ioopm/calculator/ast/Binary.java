package org.ioopm.calculator.ast;

public abstract class Binary extends SymbolicExpression {
    private SymbolicExpression lhs;
    private SymbolicExpression rhs;

    public Binary(String name, SymbolicExpression lhs, SymbolicExpression rhs) {
        super(name, lhs, rhs);
        this.lhs = lhs;
        this.rhs = rhs;
    }

    public String toString(){
        return lhs.toString() + " " + this.getName() + " " + rhs.toString();
    }

    public boolean equals(Object other) {
        if (other instanceof Binary) {
            return this.equals((Binary) other);
        } else {
            return false;
        }
    }

    public boolean equals(Binary other) {
        if (this.getName().equals(other.getName())) {
            if (this.lhs.equals(other.lhs) && (this.rhs.equals(other.rhs))) {
                return true;
            } else return false;
        } else {
            return false;
        }
    }
}   