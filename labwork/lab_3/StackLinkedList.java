package labwork.lab_3;
import java.util.Scanner;

public class StackLinkedList {

    // Node class
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Top of stack
    static Node top = null;

    // Push operation
    static void push(int data) {
        Node newNode = new Node(data);

        newNode.next = top;
        top = newNode;

        System.out.println(data + " pushed into stack.");
    }

    // Pop operation
    static void pop() {
        if (top == null) {
            System.out.println("Stack Underflow.");
            return;
        }

        System.out.println(top.data + " popped from stack.");
        top = top.next;
    }

    // Peek operation
    static void peek() {
        if (top == null) {
            System.out.println("Stack is empty.");
            return;
        }

        System.out.println("Top element: " + top.data);
    }

    // Display operation
    static void display() {
        if (top == null) {
            System.out.println("Stack is empty.");
            return;
        }

        Node temp = top;

        System.out.println("Stack elements:");

        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int choice;

        do {
            System.out.println("\n--- STACK MENU ---");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter element: ");
                    int value = sc.nextInt();
                    push(value);
                    break;

                case 2:
                    pop();
                    break;

                case 3:
                    peek();
                    break;

                case 4:
                    display();
                    break;

                case 5:
                    System.out.println("Program ended.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);

        sc.close();
    }
}