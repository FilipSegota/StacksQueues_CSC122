/****************************************************************************
 * /* Author: Filip Segota
 * /* Class: CSC 122, Fall 2020
 * /* Assignment: Lab 3: Stack and Queue
 * /* File: Array implementation for the queue
 * /
 ****************************************************************************/
public class Queue implements QueueInterface {
    // field variables
    private int head, tail, n;
    private Person[] people;

    // constructors
    public Queue() {
        people = new Person[100];
        n = 0;
        for (int i = 0; i < people.length; i++) {
            people[i] = null;
        }
        head = 0;
        tail = 0;
    }

    public Queue(int n) {
        people = new Person[n];
        this.n = 0;
        for (int i = 0; i < n; i++) {
            people[i] = null;
        }
        head = 0;
        tail = 0;
    }

    // methods
    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public boolean isFull() {
        if (n == people.length)
            return true;
        return false;
    }

    public void enqueue(Person person) throws QueueOverflowException {
        if (isFull())
            throw new QueueOverflowException("Can't add. The queue is full!");

        if (isEmpty()) {
            people[0] = person;
            tail = 0;
            head = 0;
        } else {
            tail = (tail + 1) % people.length;
            people[tail] = person;
        }
        n++;
    }

    public Person dequeue() throws QueueUnderflowException {
        Person result;

        if (isEmpty())
            throw new QueueUnderflowException("Can't remove. " +
                    "The queue is empty!");

        result = people[head];
        if (n == 1) {
            people[head] = null;
            head = 0;
            tail = 0;
        } else {
            people[head] = null;
            head = (head + 1) % people.length;
        }
        n--;

        return result;
    }

    public String toString() {
        String s;
        int i;

        s = "";

        for (i = 0; i < n; i++) {
            s += people[(head + i) % people.length].getName() + " " +
                    people[(head + i) % people.length].getColor() + " " +
                    people[(head + i) % people.length].getAmount() + "\n";
        }

        return s;
    }
}