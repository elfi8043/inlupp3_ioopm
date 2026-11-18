package org.ioopm.calculator.ast;

public class Variable extends Atom {
    private String id;

    public Variable(String id) {  
        this.id = id;
        super("Var");
    }

    public String toString(){
        return id;
    }

    public boolean equals(Object other) {
        if (other instanceof Variable) {
            return this.equals((Variable) other);
        } else {
            return false;
        }
    }

    public boolean equals(Variable other) {
        /// access a private field of other!
        return this.id.equals(other.id);
    }

    @Override 
    public Variable eval() {
        return this;
    }
}
