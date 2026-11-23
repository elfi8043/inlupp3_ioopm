# Symbolic Calculator

A symbolic calculator implemented in Java. Repo contains three parts: 
1. AST
	- An abstract syntax tree containing classes for building and operating on syntax trees made from symbolic expressions.
2. A parser
	- A parser that parses mathematical expresstions into the AST
3. A calculator
	- A simple calculator program using the AST and parser to demonstrate functionality.
	- 
## Features

- Basic arithmetic: addition, subtraction, multiplication and division.
    
- Mathematical functions: sine, cosine, logarithm and exponential.
    
- Named constants, such as `pi` and `e`.
    
- Variable assignment and lookup.
    
- Commands for listing variables, clearing the screen and quitting.
    
- Symbolic expression evaluation.
    

## Usage

Compile the project:

```bash
make
```

Run the calculator:

```bash
make run
```

Run the test suite:

```bash
make run_tests
```

Remove compiled files:

```bash
make clean
```

## Example

```text
> x = 42
> y = pi * 2
> x + y
48.283185307179586
> Vars
{x=42.0, y=6.283185307179586}
> Quit
```


## Syntax and limitations

- Assignments use the syntax `expression = variable`.
    
- Unary functions use prefix notation, e.g. `Sin(x)` or `Sin x`.
    
- Parentheses can be used to group expressions.
    
- Exponentiation (`^`), implicit multiplication and other unsupported operators are not available.
    
- `Quit`, `Vars` and `Clear` are reserved commands and cannot be used as variable names.
    
- The ans variable and named constants such as `pi` and `e` cannot be redefined.
    
- Invalid expressions, malformed assignments and unbalanced parentheses produce errors.
    
- Mathematical operations are subject to Java's floating-point behaviour, which can result in approximations, `NaN` or infinity for certain inputs.
