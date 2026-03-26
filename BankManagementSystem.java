import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * Custom Queue Implementation (FIFO)
 * Built from scratch using a Singly Linked List approach
 */
class BankQueue<T> {
    private class Node {
        T data;
        Node next;
        Node(T data) { this.data = data; }
    }

    private Node front, rear;
    private int size = 0;

    public void enqueue(T data) {
        Node newNode = new Node(data);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    public T dequeue() {
        if (isEmpty()) return null;
        T data = front.data;
        front = front.next;
        if (front == null) rear = null;
        size--;
        return data;
    }

    public boolean isEmpty() { return size == 0; }
    public int getSize() { return size; }

    /**
     * CRITICAL FIX: Added the missing clear method
     */
    public void clear() {
        front = rear = null;
        size = 0;
    }

    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("   [ Lounge is currently empty ]");
            return;
        }
        Node current = front;
        while (current != null) {
            System.out.println("   " + current.data.toString());
            current = current.next;
        }
    }
}

class Customer {
    int token;
    String name;
    String service;
    String arrivalTime;

    Customer(int token, String name, String service) {
        this.token = token;
        this.name = name;
        this.service = service;
        this.arrivalTime = LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm a"));
    }

    @Override
    public String toString() {
        return String.format("Token #%d | %-15s | Service: %-12s | Joined: %s", 
                             token, name, service, arrivalTime);
    }
}

public class BankManagementSystem {
    private static BankQueue<Customer> queue = new BankQueue<>();
    private static int tokenCounter = 1001;
    private static int totalServed = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            printHeader();
            System.out.println("1. Register New Customer");
            System.out.println("2. Serve Next Customer");
            System.out.println("3. View Waiting Lounge");
            System.out.println("4. Reset System (End of Day)");
            System.out.println("5. Exit");
            System.out.print("\nSelect an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1": registerCustomer(); break;
                case "2": serveCustomer(); break;
                case "3": viewQueue(); break;
                case "4": resetSystem(); break;
                case "5": 
                    System.out.println("Closing Horizon Premier Systems... Goodbye.");
                    scanner.close(); // Proper cleanup
                    System.exit(0);
                default: 
                    System.out.println("\n[!] Invalid selection. Please try again.");
            }
            
            System.out.println("\nPress Enter to continue...");
            scanner.nextLine();
        }
    }

    private static void printHeader() {
        System.out.println("\n==========================================");
        System.out.println("      HORIZON PREMIER BANKING SYSTEM      ");
        System.out.println("==========================================");
        System.out.println(" Customers Waiting: " + queue.getSize());
        System.out.println(" Total Served Today: " + totalServed);
        System.out.println("------------------------------------------");
    }

    private static void registerCustomer() {
        System.out.print("Enter Client Name: ");
        String name = scanner.nextLine();
        
        if (name.trim().isEmpty()) {
            System.out.println("[!] Error: Name cannot be empty.");
            return;
        }

        System.out.println("Select Service:");
        System.out.println("A. Cash Deposit");
        System.out.println("B. Withdrawal");
        System.out.println("C. Loan Consultation");
        System.out.println("D. Vault Access");
        System.out.print("Choice: ");
        String sChoice = scanner.nextLine().toUpperCase();
        
        String service;
        switch(sChoice) {
            case "A": service = "Deposit"; break;
            case "B": service = "Withdrawal"; break;
            case "C": service = "Loan"; break;
            case "D": service = "Vault"; break;
            default: service = "General";
        }

        Customer newCust = new Customer(tokenCounter++, name, service);
        queue.enqueue(newCust);
        System.out.println("\n[✔] Success: Token #" + newCust.token + " issued to " + name);
    }

    private static void serveCustomer() {
        if (queue.isEmpty()) {
            System.out.println("\n[!] Reception: No customers currently in the lounge.");
            return;
        }

        Customer served = queue.dequeue();
        totalServed++;
        System.out.println("\n******************************************");
        System.out.println("   NOW SERVING: TOKEN #" + served.token);
        System.out.println("   CLIENT     : " + served.name);
        System.out.println("   SERVICE    : " + served.service);
        System.out.println("******************************************");
    }

    private static void viewQueue() {
        System.out.println("\n--- CURRENT WAITING LOUNGE ---");
        queue.displayQueue();
    }

    private static void resetSystem() {
        System.out.print("Are you sure you want to reset the system? (Y/N): ");
        if (scanner.nextLine().equalsIgnoreCase("Y")) {
            queue.clear(); // Now this method exists!
            tokenCounter = 1001;
            totalServed = 0;
            System.out.println("\n[!] System has been reset for a new business day.");
        }
    }
}