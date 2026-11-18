package org.ioopm.calculator.ast;

import java.util.HashMap;

import javax.management.RuntimeErrorException;

import org.ioopm.calculator.ast.SymbolicExpression;

public class Assignment extends Binary {
    public Assignment(SymbolicExpression lhs, SymbolicExpression rhs)
    {
        super("=", lhs, rhs);
    }

    public SymbolicExpression eval(HashMap<Variable, SymbolicExpression> vars)
    {
        if (super.getRhs().eval(vars) instanceof Variable) {
            Variable rhs = (Variable) super.getRhs();
            vars.put(rhs, super.getLhs().eval(vars));
        }

        else {
            throw new RuntimeErrorException("Can't assign two constants.");
        }
            
    }
}
