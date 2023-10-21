/***********************************************************************
 * /* Author: Filip Segota
 * /* Class: CSC 122, Fall 2020
 * /* Assignment: Lab 3: Stack and Queue
 * /* File: QueueUnderflowException -> For underflowing queues
 * /
 ***********************************************************************/
public class QueueUnderflowException extends RuntimeException {
    // constructors
    public QueueUnderflowException() {
        super();
    }

    public QueueUnderflowException(String message) {
        super(message);
    }
}