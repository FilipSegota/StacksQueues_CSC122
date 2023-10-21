
/****************************************************************************
/* Author:      Filip Segota
/* Class:       CSC 122, Fall 2020
/* Assignment:  Lab 3: Stack and Queue
/* File:        Assembly for simulation of builders and buyers
/****************************************************************************/

import java.io.FileReader;
import java.io.IOException;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Assembly {
    // field variables
    private Queue builders, buyers;
    private Stack items;

    // constructors
    public Assembly(String filename) throws IOException {
        items = new Stack();
        builders = new Queue();
        buyers = new Queue();
        try {
            loaditems(filename);
        } catch (IOException e) {
            System.out.println("There's no file with that name!");
        }
    }

    // methods
    public void loaditems(String filename) throws IOException {
        Scanner file;
        String line;
        String[] parts;
        int type;

        // load builders and buyers
        try {
            file = new Scanner(new FileReader(filename));

            while (file.hasNext()) {
                line = file.nextLine();
                parts = line.split(" ");
                type = Integer.parseInt(parts[0]);
                if (type == 0)
                    addBuilder(parts[1], parts[2], Integer.parseInt(parts[3]));
                else
                    addBuyer(parts[1], Integer.parseInt(parts[2]));
            }
        } catch (IOException e) {
            System.out.println("There's no file with that name!");
        }
    }

    public void addItem(String color, int amount) {
        for (int i = 0; i < amount; i++)
            try {
                items.push(color);
            } catch (StackOverflowException e) {
                System.out.println(e);
            }
        return;
    }

    public void addBuilder(String name, String color, int amount) {
        Person builder;
        builder = new Person(name, color, amount);
        try {
            builders.enqueue(builder);
        } catch (QueueOverflowException e) {
            System.out.println(e);
        }
    }

    public void addBuyer(String name, int amount) {
        Person buyer;
        buyer = new Person(name, "", amount);
        try {
            buyers.enqueue(buyer);
        } catch (QueueOverflowException e) {
            System.out.println(e);
        }
    }

    public void run() {
        boolean done;
        boolean result;
        Person builder, buyer;
        Person builder2, buyer2;
        int i;
        String color;
        Scanner in = new Scanner(System.in);

        done = false;
        // check if it's over
        if (builders.isEmpty() && buyers.isEmpty()) {
            done = true;
            System.out.println("There's no more buyers nor builders. " +
                    "The simulation is over.");
            System.out.println("Input any key to finish...");
            try {
                in.next();
            } catch (Exception e) {

            }
        }
        // check if it's over
        if (builders.isEmpty() && items.isEmpty()) {
            done = true;
            System.out.println("There's no towels left nor builders to " +
                    "build more towels. The simulation is over.");
            System.out.println("Input any key to finish...");
            try {
                in.next();
            } catch (Exception e) {

            }
        }
        // check if it's over
        if (items.isFull() && buyers.isEmpty()) {
            done = true;
            System.out.println("The stack of towels is full, but there's no" +
                    " more buyers to buy any. The simulation is over.");
            System.out.println("Input any key to finish...");
            try {
                in.next();
            } catch (Exception e) {

            }
        }

        while (!done) {
            // check if there are builders left
            if (!builders.isEmpty()) {
                builder = new Person("", "", 0);
                try {
                    builder = builders.dequeue();
                } catch (QueueUnderflowException e) {
                    System.out.println(e);
                }
                // create towels if possible
                for (i = 1; i <= builder.getAmount(); i++) {
                    if (items.isFull()) {
                        builder2 = new Person(builder.getName(),
                                builder.getColor(), builder.getAmount() - i + 1);
                        try {
                            builders.enqueue(builder);
                        } catch (QueueOverflowException e) {
                            System.out.println(e);
                        }
                        System.out.println("Builder " + builder.getName() +
                                " created " + (i - 1) + " towels, but there's no " +
                                "more space in a stack of towels./nHe was added to " +
                                "the end of the queue of builders with " +
                                (builder.getAmount() - i + 1) + " towels left to create.");
                        System.out.println("Input any key to continue...");
                        try {
                            in.next();
                        } catch (Exception e) {

                        }
                        break;
                    } else {
                        try {
                            items.push(builder.getColor());
                        } catch (StackOverflowException e) {
                            System.out.println(e);
                        }
                        if (i == builder.getAmount()) {
                            System.out.println("Builder " +
                                    builder.getName() + " created " + i + " " +
                                    builder.getColor() + " towels.");
                            System.out.println("Input any key to " +
                                    "continue...");
                            try {
                                in.next();
                            } catch (Exception e) {

                            }
                        }
                    }
                }
            }
            // check if there are buyers left
            if (!buyers.isEmpty()) {
                buyer = new Person("", "", 0);
                try {
                    buyer = buyers.dequeue();
                } catch (QueueUnderflowException e) {
                    System.out.println(e);
                }
                // buy towels if possible
                for (i = 1; i <= buyer.getAmount(); i++) {
                    if (items.isEmpty()) {
                        buyer2 = new Person(buyer.getName(), "",
                                buyer.getAmount() - i + 1);
                        try {
                            buyers.enqueue(buyer2);
                        } catch (QueueOverflowException e) {
                            System.out.println(e);
                        }
                        System.out.println("Buyer " + buyer.getName() +
                                " bought " + (i - 1) + " towels, but there's no " +
                                "towels left in a stack of towels. Buyer was added " +
                                "to the end of the queue of buyers with " +
                                (buyer.getAmount() - i + 1) + " towels left to buy.");
                        System.out.println("Input any key to continue...");
                        try {
                            in.next();
                        } catch (Exception e) {

                        }
                        break;
                    } else {
                        try {
                            items.pop();
                        } catch (StackUnderflowException e) {
                            System.out.println(e);
                        }
                        if (i == buyer.getAmount()) {
                            System.out.println("Buyer " + buyer.getName() +
                                    " bought " + i + " towels.");
                            System.out.println("Input any key to " +
                                    "continue...");
                            try {
                                in.next();
                            } catch (Exception e) {

                            }
                        }
                    }
                }
            }
            // check if it's over
            if (builders.isEmpty() && buyers.isEmpty()) {
                done = true;
                System.out.println("There's no more buyers nor builders. " +
                        "The simulation is over.");
                System.out.println("Input any key to finish...");
                try {
                    in.next();
                } catch (Exception e) {

                }
            }
            // check if it's over
            if (builders.isEmpty() && items.isEmpty()) {
                done = true;
                System.out.println("There's no towels left nor builders to " +
                        "build more towels. The simulation is over.");
                System.out.println("Input any key to finish...");
                try {
                    in.next();
                } catch (Exception e) {

                }
            }
            // check if it's over
            if (items.isFull() && buyers.isEmpty()) {
                done = true;
                System.out.println("The stack of towels is full, but " +
                        "there's no more buyers to buy any. The simulation is over.");
                System.out.println("Input any key to finish...");
                try {
                    in.next();
                } catch (Exception e) {

                }
            }
        }
    }
}