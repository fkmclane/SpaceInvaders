JC = javac
JFLAGS = 

SRC = $(wildcard *.java)

ifdef SystemRoot
	RM = del /Q
	JFLAGS += -cp .;..\..\gridworld.jar
else
	RM = rm -f
	JFLAGS += -cp .:../../gridworld.jar
endif

.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) $*.java

all: $(SRC:.java=.class)

clean:
	$(RM) *.class

.PHONY: all clean
