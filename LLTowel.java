/****************************************************************************
 * /* Author: Filip Segota
 * /* Class: CSC 122, Fall 2020
 * /* Assignment: Lab 3: Stack and Queue
 * /* File: Linked list node for towels
 * /
 ****************************************************************************/
public class LLTowel {
    // field variables
    String color;
    LLTowel next;

    // constructors
    public LLTowel() {
        color = null;
        next = null;
    }

    public LLTowel(String color) {
        this.color = color;
        next = null;
    }

    public LLTowel(String color, LLTowel next) {
        this.color = color;
        this.next = next;
    }

    // accessors
    public String getColor() {
        return color;
    }

    public LLTowel getNext() {
        return next;
    }

    // mutators
    public void setColor(String color) {
        this.color = color;
    }

    public void setNext(LLTowel next) {
        this.next = next;
    }
}