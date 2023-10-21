/****************************************************************************
 * /* Author: Filip Segota
 * /* Class: CSC 122, Fall 2020
 * /* Assignment: Lab 3: Stack and Queue
 * /* File: Linked list implementation for the stack
 * /
 ****************************************************************************/
public class Stack implements StackInterface {
    // field variables
    LLTowel head;

    // constructors
    public Stack() {
        head = null;
    }

    public Stack(String color) {
        head = new LLTowel(color);
    }

    // methods
    public void add(String color) {
        LLTowel NewTowel;

        NewTowel = new LLTowel(color.toLowerCase());
        NewTowel.setNext(head);
        head = NewTowel;
    }

    public String remove() {
        String s;

        s = head.getColor();
        head = head.getNext();

        return s;
    }

    public int size() {
        if (head == null)
            return 0;

        int n;
        LLTowel cur;

        n = 0;
        cur = head;

        while (cur != null) {
            n++;
            cur = cur.getNext();
        }
        return n;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public boolean isFull() {
        return false; // Linked list can't be full
    }

    // add to the stack
    public void push(String color) throws StackOverflowException {
        if (isFull()) // never happens
            throw new StackOverflowException("Can't add. The stack is full!");
        add(color);
    }

    // remove from the stack
    public String pop() throws StackUnderflowException {
        if (isEmpty())
            throw new StackUnderflowException("Can't remove. " +
                    "The stack is empty!");
        return remove();
    }

    // access the top item
    public String top() throws StackUnderflowException {
        if (isEmpty())
            throw new StackUnderflowException("Can't access top. " +
                    "The stack is empty!");
        return head.getColor();
    }

    public String toString() {
        if (head == null)
            return "";
        String s;
        LLTowel cur;

        s = "";
        cur = head;

        while (cur != null) {
            s += cur.getColor();
            cur = cur.getNext();
        }

        return s;
    }
}
