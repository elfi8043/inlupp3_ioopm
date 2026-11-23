package org.ioopm.calculator.ast;

/**
 * Represents the Quit command which will finish / abort execution
 * Quit
 */
public class Quit extends Command {
    private static final Quit theInstance = new Quit();

    private Quit() {
        super("quit");
    }

    public static Quit instance() {
        return theInstance;
    }
}
