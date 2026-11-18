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

    public void testEvaluating(SymbolicExpression expected, SymbolicExpression e) {
        SymbolicExpression r = e.eval();
        if (r.equals(expected)) {
            System.out.println("Passed: " + e);
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
        
    }

    public void main() {
        this.t1();
        this.t2();
        this.t3();
        this.t4();
    }
}