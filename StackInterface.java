
/****************************************************************************
 * /* Author: Filip Segota
 * /* Class: CSC 122, Fall 2020
 * /* Assignment: Lab 3: Stack and Queue
 * /* File: Stack Interface
 * /
 ****************************************************************************/
public interface StackInterface {
    public void add(String color);

    public String remove();

    public int size();

    public boolean isEmpty();

    public boolean isFull();

    public void push(String color) throws StackOverflowException;

    public String pop() throws StackUnderflowException;

    public String top() throws StackUnderflowException;

    public String toString();
}