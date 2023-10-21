/***********************************************************************
 * /* Author: Filip Segota
 * /* Class: CSC 122, Fall 2020
 * /* Assignment: Lab 3: Stack and Queue
 * /* File: QueueOverflowException -> For overflowing queues
 * /
 ***********************************************************************/
public class QueueOverflowException extends RuntimeException {
    // constructors
    public QueueOverflowException() {
        super();
    }

    public QueueOverflowException(String message) {
        super(message);
    }
}