
/****************************************************************************
/* Author:      Filip Segota
/* Class:       CSC 122, Fall 2020
/* Assignment:  Lab 3: Stack and Queue
/* File:        Assembly driver
/****************************************************************************/
import java.io.IOException;
import java.util.Scanner;

public class AssemblyDriver {
    public static void main(String[] args) {
        Assembly assembly;
        Scanner keyboard;
        String filename;

        // get the file
        // create the Assembly
        // run the Assembly
        keyboard = new Scanner(System.in);
        System.out.println("What is the name of the file?");
        filename = keyboard.nextLine();
        try {
            assembly = new Assembly(filename);
            assembly.run();
        } catch (IOException e) {
            System.out.println("Something went wrong!");
        }
    }
}