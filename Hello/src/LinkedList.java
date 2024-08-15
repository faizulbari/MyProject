import java.time.Duration;
import java.time.Instant;
import java.util.Random;
import java.util.Scanner;

public class LinkedList {

    class Node {
        Node next;
        int data;

        Node(int newData) {
            data = newData;
            next = null;
        }
    }

    Node generateLinkedList(int num) {
        Node head = null;
        Random rand = new Random();

        //set the bound to the maximum number in the digit
        int numOfDigits = String.valueOf(num).length();
        int maxBoundary = (int) Math.pow(10, numOfDigits);
        System.out.println("Inserting the following random numbers");
        for (int i = 0; i < num; i++) {
            int randNumber = rand.nextInt(maxBoundary);
            System.out.print(randNumber + " ");
            head = insertInSortedOrder(head, randNumber);
        }

        return head;
    }

    Node inserNodeAtFront(Node head, int data) {
        Node new_node = new Node(data);
        new_node.next = head;
        return new_node;

    }

    Node insertNodeAtEnd(Node head, int newData) {
        // Create a new node
        Node newNode = new Node(newData);

        // If the Linked List is empty, make the
        // new node the head
        if (head == null) {
            return newNode;
        }

        // Store the head reference in a temporary variable
        Node last = head;

        // Traverse till the last node
        while (last.next != null) {
            last = last.next;
        }

        // Change the next pointer of the
        // last node to point to the new node
        last.next = newNode;

        // Return the head of the list
        return head;
    }


    Node insertInSortedOrder(Node head, int data) {
        if (head == null || data < head.data ) {
            return inserNodeAtFront(head, data);
        } else {
            Node prev = head;
            Node next = head;
            while (next != null) {

                next = next.next;
                if(next == null){
                    head = insertNodeAtEnd(head, data);
                    return head;
                }
                else if (data <= next.data) {
                    Node newnode = new Node(data);
                    newnode.next = next;
                    prev.next = newnode;
                    return head;
                } else if (data > next.data) {
                    prev = prev.next;
                }
            }

        }
        return head;
    }

    private void printLinkedList(Node head) {
        Node node = head;
        System.out.println("\n Printing the Linked list");
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;

        }
    }


    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the n value to generate a random Limnked List");
        int in = scanner.nextInt();

        LinkedList ll = new LinkedList();
        Node head = ll.generateLinkedList(in);
        ll.printLinkedList(head);


    }


}

