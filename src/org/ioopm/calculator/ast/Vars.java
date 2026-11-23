package org.ioopm.calculator.ast;

/**
 * Represents the command that lists all variables in the environment.
 *
 * <p>This class follows the Singleton pattern, ensuring that only one
 * instance of {@code Vars} exists.
 */
public class Vars extends Command {
    private static final Vars theInstance = new Vars();

    /**
     * Creates the singleton instance of the {@code Vars} command.
     *
     * <p>The constructor is private to prevent other classes from creating
     * additional instances.
     */
    private Vars() {
        super("vars");
    }

    /**
     * Returns the singleton instance of {@code Vars}.
     *
     * @return the single {@code Vars} instance
     */
    public static Vars instance() {
        return theInstance;
    }
}