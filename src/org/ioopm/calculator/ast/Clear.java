package org.ioopm.calculator.ast;

public class Clear extends Command {
    private static final Clear theInstance = new Clear();

    private Clear() {
        super("clear");
    }

    public static Clear instance() {
        return theInstance;
    }
}
