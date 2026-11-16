package org.ioopm.calculator.ast;

import org.ioopm.calculator.ast.SymbolicExpression;

public class Assignment extends Binary {
    private String varName;
    private SymbolicExpression val;
}
