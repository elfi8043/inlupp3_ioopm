JAVA = java
SRC = src
CLASSES = classes
PACKAGE = org.ioopm.calculator

all:
	javac -d $(CLASSES) -sourcepath $(SRC) $(SRC)/$(subst .,/,$(PACKAGE))/Calculator.java

run: all
	java -cp $(CLASSES) $(PACKAGE).Calculator

tests:
	javac -d $(CLASSES) -sourcepath $(SRC) $(SRC)/$(subst .,/,$(PACKAGE))/Test.java

run_tests: tests
	java -cp $(CLASSES) $(PACKAGE).Test

clean:
	rm -rf $(CLASSES)

.PHONY: all run tests run_tests clean
