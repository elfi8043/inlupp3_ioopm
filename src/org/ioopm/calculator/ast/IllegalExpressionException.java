package org.ioopm.calculator.ast;

/**
 * Thrown when an expression or operation in the AST is invalid.
 */
public class IllegalExpressionException extends RuntimeException {

    /**
     * Constructs a new {@code IllegalExpressionException} with the provided message.
     * @param msg the message provided along with the error, explaining why it is disallowed.
     */
    public IllegalExpressionException(String msg) {
        super(msg);
    }
}