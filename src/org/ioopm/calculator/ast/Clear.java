package org.ioopm.calculator.ast;

/**
 * Represents the clear command in the AST tree.
 */
public class Clear extends Command {
    private static final Clear theInstance = new Clear();

    /**
     * Creates the {@code Clear} command instance.
     */
    private Clear() {
        super("clear");
    }

    /**
     * Returns the instance of the {@code Clear} command.
     * @return the shared {@code Clear} instance.
     */
    public static Clear instance() {
        return theInstance;
    }
}
