package org.ioopm.calculator.ast;

/**
 * Thrown when an assignment is attempted to be made on
 * an invalid variable. Such as a named constant.
 */
public class IllegalAssignmentException extends RuntimeException {

    /**
     * Constructs a new {@code IllegalAssignmentException} with the provided message.
     * @param msg the message provided along with the error, explaining why it is disallowed.
     */
    public IllegalAssignmentException(String msg) {
        super(msg);
    }
}