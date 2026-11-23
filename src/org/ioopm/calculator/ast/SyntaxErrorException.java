package org.ioopm.calculator.ast;

/**
 * Error class that gets thrown when invalid syntax is used
 * SyntaxErrorException
 */
public class SyntaxErrorException extends RuntimeException {

    public SyntaxErrorException(String msg) {
        super(msg);
    }
}