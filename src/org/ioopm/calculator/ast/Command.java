package org.ioopm.calculator.ast;

import java.util.HashMap;

import javax.management.RuntimeErrorException;

import org.ioopm.calculator.ast.SymbolicExpression;

/**
 * Represents a command in the AST tree, such as {@link Clear}, {@link Quit} or {@link Vars}.
 */
public abstract class Command extends SymbolicExpression {
    private SymbolicExpression arg;

    /**
     * Initializes a command with the given name.
     * @param command the name of the command
     */
    public Command(String command) {
        super(command);
    }

    /**
     * A command cannot be evaluated, therefore throws a {@link RuntimeException}.
     * 
     * @param vars the variable environment used for evaluating variables.
     * @throws RuntimeException when called on a command.
     * @see org.ioopm.calculator.ast.SymbolicExpression#eval(org.ioopm.calculator.ast.Environment)
     */
    @Override
    public SymbolicExpression eval(Environment vars) {
        throw new RuntimeException("A command can not be evaluated");
    }

    /**
     * Indicates that the expression is a command.
     * @see org.ioopm.calculator.ast.SymbolicExpression#isCommand()'
     * @return true.
     */
    @Override 
    public boolean isCommand() {
        return true;
    }
} 