package org.ioopm.calculator.ast;

public class Subtraction extends Binary {
    public class Subtraction(SymbolicExpression lhs, SymbolicExpression rhs)
    {
        super("-", lhs, rhs);
    }
}