package org.ioopm.calculator.ast;

import org.ioopm.calculator.ast.SymbolicExpression;

public class Assignment extends Binary {
    public Assignment(SymbolicExpression lhs, SymbolicExpression rhs)
    {
        super("=", lhs, rhs);
    }
}
