package org.ioopm.calculator; 
import org.ioopm.calculator.ast.*;
import org.ioopm.calculator.parser.CalculatorParser;

import java.io.IOException;

public class Calculator {

    public static void main(String[] args) throws IOException {
        CalculatorParser p = new CalculatorParser();
        Environment vars = new Environment();

        while (true) {
            System.out.print("$> ");
            String input = System.console().readLine(); 

            try {
                SymbolicExpression res = p.parse(input, vars);

                // Handle commands
                if (res instanceof Quit) {
                    return;
                } else if (res instanceof Clear) {
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    continue;
                } else if (res instanceof Vars) {
                    System.out.println(vars.toString());
                    continue;
                }
                // Not a command -> eval expression and print
                SymbolicExpression ans = res.eval(vars);
                System.out.println(ans);

            } catch (RuntimeException e) {
                System.out.println("Error: " + e.getMessage());
            }

        }

    }
}



