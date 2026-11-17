package org.ioopm.calculator.ast;

public class Log extends Unary {
    public Log(SymbolicExpression arg) {
        super("log", arg);
    }
     
    @Override 
    public String getName() {
        return "log";
    }
}