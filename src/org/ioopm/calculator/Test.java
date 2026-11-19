package org.ioopm.calculator; 
import org.ioopm.calculator.ast.*;

import java.io.IOException;

public class Test {
    public void testPrinting(String expected, SymbolicExpression e) {
        if (expected.equals("" + e)) {
            System.out.println("Passed: " + e);
        } else {
            System.out.println("Error: expected '" + expected + "' but got '" + e + "'");
        }
    }

    public void testEvaluating(SymbolicExpression expected, SymbolicExpression e, Environment vars) {
        SymbolicExpression r = e.eval(vars);
        if (r.equals(expected)) {
            System.out.println("Passed: " + r);
        } else {
            System.out.println("Error: expected '" + expected + "' but got '" + e + "'");
        }
    }

    public void t1() {
        Constant c1 = new Constant(5);
        Constant c2 = new Constant(2);
        Variable v = new Variable("x");
        Addition a = new Addition(c1, v);
        Multiplication m = new Multiplication(a, c2);
        this.testPrinting("(5 + x) * 2", m);
    }

    public void t2() {
        Constant c1 = new Constant(3);
        Sin sin = new Sin(c1);
        this.testPrinting("sin 3.0", sin);
    }

    public void t3() {
        Constant c1 = new Constant(3);
        Constant c2 = new Constant(2);
        Addition bin = new Addition(c1, c2);
        this.testPrinting("3.0 + 2.0", bin);
    }

    public void t4() {
        Variable v1 = new Variable("a");
        Variable v2 = new Variable("b");
        Variable v3 = new Variable("c");
        Variable v4 = new Variable("d");

        Addition a1 = new Addition(v1, v2);
        Subtraction s1 = new Subtraction(v3, v4);
        Multiplication m1 = new Multiplication(a1, s1);

        Subtraction s2 = new Subtraction(v1, v3);
        Addition a2 = new Addition(v4, v2);
        Addition a3 = new Addition(s2, a2);

        Division d1 = new Division(m1, a3);
        this.testPrinting("a + b * c - d / a - c + d + b", d1);
    }

    public void t5() {
        Constant c1 = new Constant(3);
        Constant c2 = new Constant(5);
        Addition a1 = new Addition(c1, c2);

        Constant c3 = new Constant(3);
        Constant c4 = new Constant(5);
        Addition a2 = new Addition(c3, c4);

        Sin s1 = new Sin(a1);
    }

    public void t6_const_add() {
        Environment vars = new Environment();
        Constant c1 = new Constant(5);
        Constant c2 = new Constant(6);
        Addition a1 = new Addition(c1, c2);

        Constant res = new Constant(11);

        testEvaluating(res, a1, vars);
    }

    public void t7_const_sub() {
    Environment vars = new Environment();
    Constant c1 = new Constant(10);
    Constant c2 = new Constant(4);
    Subtraction s1 = new Subtraction(c1, c2);

    Constant res = new Constant(6);

    testEvaluating(res, s1, vars);
    }

    public void t8_const_mult() {
        Environment vars = new Environment();
        Constant c1 = new Constant(5);
        Constant c2 = new Constant(6);
        Multiplication m1 = new Multiplication(c1, c2);

        Constant res = new Constant(30);

        testEvaluating(res, m1, vars);
    }

    public void t9_const_div() {
        Environment vars = new Environment();
        Constant c1 = new Constant(12);
        Constant c2 = new Constant(3);
        Division d1 = new Division(c1, c2);

        Constant res = new Constant(4);

        testEvaluating(res, d1, vars);
    }

    public void t10_const_sin() {
        Environment vars = new Environment();
        Constant c1 = new Constant(0);
        Sin s1 = new Sin(c1);

        Constant res = new Constant(0);

        testEvaluating(res, s1, vars);
    }

    public void t11_const_cos() {
        Environment vars = new Environment();
        Constant c1 = new Constant(0);
        Cos cos1 = new Cos(c1);

        Constant res = new Constant(1);

        testEvaluating(res, cos1, vars);
    }

    public void t12_const_log() {
        Environment vars = new Environment();
        Constant c1 = new Constant(1);
        Log l1 = new Log(c1);

        Constant res = new Constant(0);

        testEvaluating(res, l1, vars);
    }

    public void t13_const_exp() {
        Environment vars = new Environment();
        Constant c1 = new Constant(0);
        Exp e1 = new Exp(c1);

        Constant res = new Constant(1);

        testEvaluating(res, e1, vars);
    }

    public void t14_const_neg() {
        Environment vars = new Environment();
        Constant c1 = new Constant(5);
        Negate n1 = new Negate(c1);

        Constant res = new Constant(-5);

        testEvaluating(res, n1, vars);
    }

    public void t15_assign_variable() {
        log("t16_assign_variable");
        Environment vars = new Environment();

        Variable x = new Variable("x");
        Constant c1 = new Constant(10);

        Assignment a1 = new Assignment(c1, x);

        testEvaluating(new Constant(10), a1, vars);
        testEvaluating(new Constant(10), x, vars);
    }

    public void t17_reassign_variable() {
        log("t17_reassign_var");
        Environment vars = new Environment();

        Variable x = new Variable("x");

        Assignment a1 = new Assignment(new Constant(10), x);
        Assignment a2 = new Assignment(new Constant(20), x);

        testEvaluating(new Constant(10), a1, vars);
        testEvaluating(new Constant(20), a2, vars);
        testEvaluating(new Constant(20), x, vars);
    }

    public void t18_assign_variable_to_variable() {
        log("t18_assign_variable_to_variable");
        Environment vars = new Environment();

        Variable x = new Variable("x");
        Variable y = new Variable("y");

        Assignment a1 = new Assignment(new Constant(10), x);
        Assignment a2 = new Assignment(x, y);

        testEvaluating(new Constant(10), a1, vars);
        testEvaluating(new Constant(10), a2, vars);
        testEvaluating(new Constant(10), y, vars);
    }

    public void t19_assign_expression() {
        log("t19 assign expression");
        Environment vars = new Environment();

        Variable x = new Variable("x");
        Variable y = new Variable("y");

        Assignment a1 = new Assignment(new Constant(10), x);
        Addition add = new Addition(x, new Constant(5));
        Assignment a2 = new Assignment(add, y);

        testEvaluating(new Constant(10), a1, vars);
        testEvaluating(new Constant(15), a2, vars);
        testEvaluating(new Constant(15), y, vars);
    }

    public void t20_variable_substitution() {
        log("t20 variable substitution");
        Environment vars = new Environment();

        Variable x = new Variable("x");
        Variable y = new Variable("y");

        Assignment a1 = new Assignment(new Constant(10), x);
        Addition add = new Addition(x, y);

        testEvaluating(new Constant(10), a1, vars);
        testEvaluating(new Addition(new Constant(10), y), add, vars);
    }

    public void t21_symbolic_assignment() {
        log("t21 symbolic assignment");
        Environment vars = new Environment();

        Variable x = new Variable("x");
        Variable y = new Variable("y");

        Addition add = new Addition(x, new Constant(5));
        Assignment a1 = new Assignment(add, y);

        testEvaluating(add, a1, vars);
        testEvaluating(add, y, vars);
    }

    public void t22_named_const() {
        Environment vars = new Environment();
        Addition add1 = new Addition(new NamedConstant("Answer", 42), new NamedConstant("Answer", 42));
        Constant res = new Constant(84);

        testEvaluating(res, add1, vars);

    }

    public void log(String msg) {
        System.out.println(msg);
    }

    public void main() {
        t22_named_const();
    }
}