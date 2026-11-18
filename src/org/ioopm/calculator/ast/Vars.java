package org.ioopm.calculator.ast;

import javax.lang.model.util.SimpleTypeVisitor14;

public class Vars extends Command {
    private static final Vars theInstance = new Vars();

    private Vars() {
        super("vars");
    }

    public static Vars instance() {
        return theInstance;
    }
}