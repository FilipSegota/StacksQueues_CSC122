# StacksQueues_CSC122
## Info
**Author:**
Filip Segota  
**Class:**
CSC 122 (Programming 2), Fall 2020  
**Assignment:**
Stacks and Queues Assignment 

## Overview
Create a program that simulates a factory that makes and sells towels. The towels only differ by color. The creators of the towels are subcontractors and they report each day with a certain number of towels, all of the same color. The buyers also come in each day wanting to buy towels (color does not matter). The system alternates between processing a creator and a buyer. The towels are placed on a stack and retrieved off the stack. The stack only has a specific amount of room. If there is no room for a creator to add created towels, they place what there is room for and then go back to the end of the creator line with the rest of the towels. If there are not enough towels available for a buyer, they take what remains and then go to the end of the buyer line to get the other ones. The system ends when all that can be processed has been processed.

## Program Summary
  - Gets the name of the file
  - Creates Assembly instance using try/catch and loads the items from the file
  - Runs the program
  - Simulation runs as long as it's possible:
    - If there are builders left, they create towels as long as there's room in the stack. If there's no room, the builder is put at the end of the queue
    - If there are buyers left, they buy towels as long as there are towels in the stack. If there's none, the buyer is put at the end of the queue
  - Displays the result of each event
  - There are exception classes for stacks and queues underflows and overflows
    - There is code in the Assembly to handle the exceptions from the stacks and queues
  - There is one test file (test.txt)
