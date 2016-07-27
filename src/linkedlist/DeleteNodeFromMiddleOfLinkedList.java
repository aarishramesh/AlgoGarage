package linkedlist;

import java.util.Scanner;

public class DeleteNodeFromMiddleOfLinkedList {
    public static void main(String[] args) {
        Scanner sc = null;
        try {
            System.out.println("Enter the number of elements in the linked list");
            sc = new Scanner(System.in);
            int n = sc.nextInt();
            if (n <= 0 || n >= Integer.MAX_VALUE) {
                return;
            }
            System.out.println("Enter the elements ");
            sc.nextLine();
            String input = sc.nextLine();
            linkedlist.Node head = new linkedlist.Node(input);
            linkedlist.Node prevNode = head;
            linkedlist.Node middle = null;
            for (int i = 1; i < n; i++) {
                linkedlist.Node node = new linkedlist.Node(sc.nextLine());
                prevNode.setNext(node);
                prevNode = node;
                if (i == n/2) {
                    middle = node;
                }
            }
            
  /*          // Printing the original linked list before middle element deletion
            linkedlist.Node node = head;
            while (node != null) {
                System.out.println(node.getData());
                node = node.getNext();
            }*/
            
            deleteMiddleNode(middle);
            
            // Printing the linked list after middle element deletion
            node = head;
            while (node != null) {
                System.out.println(node.getData());
                node = node.getNext();
            }
        } finally {
            sc.close();
        }
    }
    
    static void deleteMiddleNode(linkedlist.Node middleNode) {
        middleNode.data = middleNode.next.data;
        middleNode.next = middleNode.next.next;
    }
}
