
/****************************************************************************
 * /* Author: Filip Segota
 * /* Class: CSC 122, Fall 2020
 * /* Assignment: Lab 3: Stack and Queue
 * /* File: Queue Interface
 * /
 ****************************************************************************/
public interface QueueInterface {
    public int size();

    public boolean isEmpty();

    public boolean isFull();

    public void enqueue(Person person) throws QueueOverflowException;

    public Person dequeue() throws QueueUnderflowException;

    public String toString();
}