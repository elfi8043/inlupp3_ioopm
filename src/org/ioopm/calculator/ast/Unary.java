package inluppar.inlupp3.src.org.ioopm.ast;

public abstract class Unary extends SymbolicExpression {
    private String functionName;
    private SymbolicExpression arg;

    public Unary(SymbolicExpression arg)
    {
        this.arg = arg;
    }
}
