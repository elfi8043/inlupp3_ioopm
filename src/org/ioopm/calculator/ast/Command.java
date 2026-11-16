package org.ioopm.calculator.ast;

import org.ioopm.calculator.ast.SymbolicExpression;

public abstract class Command extends SymbolicExpression {
    private SymbolicExpression arg;

    public Command(SymbolicExpression command) {
        super(command);
    }
} 