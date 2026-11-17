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

    public void main() {
        this.t2();
    }
}