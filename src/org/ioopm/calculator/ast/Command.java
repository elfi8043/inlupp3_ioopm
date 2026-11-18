package org.ioopm.calculator.ast;

import java.util.HashMap;

import javax.management.RuntimeErrorException;

import org.ioopm.calculator.ast.SymbolicExpression;

public abstract class Command extends SymbolicExpression {
    private SymbolicExpression arg;

    public Command(String command) {
        super(command);
    }

    @Override
    public SymbolicExpression eval(Environment vars) {
        throw new RuntimeErrorException("A command can not be evaluated");
    }

    @Override 
    public boolean isCommand() {
        return true;
    }
} 