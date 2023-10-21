/***********************************************************************
 * /* Author: Filip Segota
 * /* Class: CSC 122, Fall 2020
 * /* Assignment: Lab 3: Stack and Queue
 * /* File: StackUnderflowException -> For underflowing stacks
 * /
 ***********************************************************************/
public class StackUnderflowException extends RuntimeException {
    // constructors
    public StackUnderflowException() {
        super();
    }

    public StackUnderflowException(String message) {
        super(message);
    }
}