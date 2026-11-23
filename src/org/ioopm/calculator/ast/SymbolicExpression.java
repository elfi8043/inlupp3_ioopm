
package org.ioopm.calculator.ast;

/**
 * Represents the base class for all expressions in the calculator's
 * abstract syntax tree (AST).
 *
 * <p>All calculator expressions inherit from this class, including
 * constants, variables, mathematical operations and commands.
 * Expressions can be evaluated in an environment, converted to strings
 * and queried for properties such as their type and operator precedence.
 *
 * <p>Subclasses override methods to provide behaviour specific to
 * their expression type.
 */
public abstract class SymbolicExpression {
    public String name;
    private String[] subExpressions;

    /**
     * Creates a symbolic expression with a name and zero or more
     * subexpressions.
     *
     * <p>The supplied subexpressions are converted to strings and
     * stored for use when representing the expression.
     *
     * @param name the name identifying the expression
     * @param subExpressions the subexpressions belonging to this expression
     */
    public SymbolicExpression(String name, Object... subExpressions) {
        this.name = name;
        this.subExpressions = new String[subExpressions.length];
        for (int i = 0; i < subExpressions.length; ++i) {
            this.subExpressions[i] = subExpressions[i].toString();
        }
    }

    /**
     * Returns a string representation of this expression.
     *
     * <p>The representation consists of the expression name followed
     * by its subexpressions enclosed in parentheses and separated by
     * commas.
     *
     * <p>For example, an expression named "Constant" with the
     * subexpression "42" is represented as "Constant(42)".
     *
     * @param msg an argument currently unused by the implementation
     * @return a string representation of the expression
     */
    public String toString(String msg) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name);
        sb.append("(");
        for (int i = 0; i < this.subExpressions.length; ++i) {
            sb.append(this.subExpressions[i]);
            if (i + 1 < subExpressions.length) {
                sb.append(", ");
            }
        }
        sb.append(")");
        return sb.toString();
    }

    /**
     * Determines whether this expression represents a constant.
     *
     * <p>Subclasses representing constants should override this method.
     *
     * @return true if this expression is a constant, otherwise false
     */
    public boolean isConstant() {
        return false;
    }

    /**
     * Returns the name of the operation represented by this expression.
     *
     * <p>Subclasses representing operations should override this method.
     *
     * @return the name of the operation
     * @throws RuntimeException if the expression does not represent
     *         an operation
     */
    public String getName() {
        throw new RuntimeException("getName() called on expression with no operator");
    }

    /**
     * Returns the operator precedence of this expression.
     *
     * <p>Subclasses representing operations can override this method
     * to specify their precedence. The default priority is 50.
     *
     * @return the operator precedence of the expression
     */
    public int getPriority() {
        return 50;
    }

    /**
     * Returns the numerical value of this expression.
     *
     * <p>Subclasses representing numerical constants should override
     * this method.
     *
     * @return the numerical value of the expression
     * @throws RuntimeException if the expression does not represent
     *         a numerical constant
     */
    public double getValue() {
        throw new RuntimeException("getValue() called on expression that is not a constant");
    }

    /**
     * Evaluates this expression in the given environment.
     *
     * <p>Evaluation may resolve variables, calculate mathematical
     * operations or produce a partially evaluated expression,
     * depending on the expression type and its operands.
     *
     * @param vars the environment containing variable bindings
     * @return the evaluated symbolic expression
     */
    public abstract SymbolicExpression eval(Environment vars);

    /**
     * Determines whether this expression represents a calculator command.
     *
     * <p>Subclasses representing commands should override this method.
     *
     * @return true if this expression is a command, otherwise false
     */
    public boolean isCommand() {
        return false;
    }
}
