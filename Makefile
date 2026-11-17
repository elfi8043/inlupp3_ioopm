all:
	javac -d classes -sourcepath src src/org/ioopm/calculator/Calculator.java

run:
	java -cp classes org.ioopm.calculator.Calculator

tests: 
	javac -d classes -sourcepath src src/org/ioopm/calculator/Test.java

run_tests: tests
	java -cp classes org.ioopm.calculator.Test

clean:
	rm -rf classes