/***********************************************************************
 * /* Author: Filip Segota
 * /* Class: CSC 122, Fall 2020
 * /* Assignment: Lab 3: Stack and Queue
 * /* File: StackOverflowException -> For overflowing stacks
 * /
 ***********************************************************************/
public class StackOverflowException extends RuntimeException {
    // constructors
    public StackOverflowException() {
        super();
    }

    public StackOverflowException(String message) {
        super(message);
    }
}