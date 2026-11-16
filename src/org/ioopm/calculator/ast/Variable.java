package org.ioopm.calculator.ast;

public class Variable extends Atom {
    private String id;

    public Variable(char id) {  
        this.id = id;
        super("Var");
    }
}
