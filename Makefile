JC = javac
JAR = jar
JFLAGS = 

SRC = $(wildcard src/*.java)

ifdef SystemRoot
	RM = del /Q
	JFLAGS += -cp gridworld;src -d resources
else
	RM = rm -f
	JFLAGS += -cp gridworld:src -d resources
endif

.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) $*.java

all: $(SRC:.java=.class)

dist: all jar clean

jar:
	$(JAR) cvfe SpaceInvaders.jar SpaceInvaders -C resources . -C gridworld .

clean:
	$(RM) resources/*.class

.PHONY: all dist clean
