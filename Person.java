/****************************************************************************
 * /* Author: Filip Segota
 * /* Class: CSC 122, Fall 2020
 * /* Assignment: Lab 3: Stack and Queue
 * /* File: Person class
 * /
 ****************************************************************************/
public class Person {
    // field variables
    private String name, color;
    private int amount;

    // constructors
    public Person(String name, String color, int amount) {
        this.name = name;
        this.color = color;
        this.amount = amount;
    }

    // methods
    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getAmount() {
        return amount;
    }
}