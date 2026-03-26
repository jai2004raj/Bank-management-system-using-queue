The Bank Queue Management System is a console-based Java application that simulates a real-world banking queue. It efficiently manages
customer flow using the First-In-First-Out (FIFO) principle implemented through a custom queue built with a singly linked list.

This project demonstrates core concepts of Data Structures and Object-Oriented Programming (OOP) without using Java’s built-in queue 
libraries.

Features:

✅ Customer Registration with unique token number

✅ Multiple service options (Deposit, Withdrawal, Loan, Vault)

✅ Real-time queue management using FIFO

✅ Display waiting customers

✅ Serve customers in order

✅ Track total customers served

✅ Reset system for a new business day

✅ Input validation for better reliability

Technologies Used:

Programming Language: Java

Concepts:

Data Structures (Queue using Linked List)

💻 System Requirements

Hardware:-

Processor: Intel i3 or above

RAM: 4 GB minimum

Storage: 100 MB free space

Software:-

Java JDK 8 or above

Any IDE (Eclipse / IntelliJ / VS Code) or Command Prompt

Object-Oriented Programming

Time Handling (LocalTime, DateTimeFormatter)

How to Run:-

Save the file:

BankManagementSystem.java

Compile the program:

javac BankManagementSystem.java

Run the program:

java BankManagementSystem

📋 Menu Options

1. Register New Customer

2. Serve Next Customer

3. View Waiting Lounge

4. Reset System (End of Day)

5. Exit

How It Works

a. Customers are added to the queue using enqueue()

b. Customers are served using dequeue()

c. The queue follows FIFO (First-In-First-Out)

d. Each customer gets:
      Token Number:
      Name:
e. Service Type

f. Arrival Time

Learning Outcomes:

Implementation of Queue using Linked List

Understanding FIFO scheduling

Real-world system simulation

Clean and modular Java programming

Conclusion

This project provides a practical approach to understanding queue data structures and their real-world applications in banking systems. It is simple, efficient, and easily extendable for advanced features.
