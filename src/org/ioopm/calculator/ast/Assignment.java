package org.ioopm.calculator.ast;

import java.util.HashMap;

import javax.management.RuntimeErrorException;

import org.ioopm.calculator.ast.SymbolicExpression;

public class Assignment extends Binary {
    public Assignment(SymbolicExpression lhs, SymbolicExpression rhs)
    {
        super("=", lhs, rhs);
    }

    public SymbolicExpression eval(Environment vars) {
        if (super.getRhs() instanceof Variable) {
            Variable rhs = (Variable) super.getRhs();

            SymbolicExpression value = super.getLhs().eval(vars);

            vars.put(rhs, value);

            return value;
        } else {
            throw new IllegalArgumentException("Can't assign to a non-variable.");
        }
    }
}
