package linkedlist;

import java.util.Scanner;

/**
 * Given an input of the form { a b c d e f 1 2 3 4 5 6 }
 * 
 * Output should be re-arranged as { a 1 b 2 c 3 d 4 e 5 f 6 }
 * 
 * Implementation using arraylists - Inefficient when performed in-place
 *  
 *  Space complexity - O(n) | Time complexity - O(n)
 * 
 * Implementation using linkedlists - Can be efficiently performed in-place
 * 
 *  Space complexity - O(1) | Time complexity - O(n)
 * 
 * Linked lists are better suited for problems involving re-arrangements
 * 
 * @author aarishramesh
 *
 */
public class RearrangeUsingLinkedList {

    public static void main(String[] args) {

        int n = 10;
        char[] inputArr = {'a', 'b', 'c', 'd', 'e', '1', '2', '3', '4', '5'};

        //Creating & populating a linked list
        Node head = new Node(inputArr[0]);
        Node prevNode = head;
        for (int i = 1; i < inputArr.length; i++) {
            Node node = new Node(inputArr[i]);
            prevNode.setNext(node);
            prevNode = node;
        }

        // Printing the original array
        Node node = head;
        while (node != null) {
            System.out.println(node.getData());
            node = node.getNext();
        }
        
        //Iterating through the linkedList & rearranging it using two pointers

        //Both the pointer nodes are obtained
        Node ptr1node = head;
        Node ptr2node = null;
        node = head;
        int i = 1;
        while (node.getNext() != null) {
            node = node.getNext();
            i++;
            if (i == n /2 + 1) {
                ptr2node = node;
                break;
            }
        }

        i = 0;
        while (ptr1node != null && ptr2node != null) {
            Node ptr1NextNode = ptr1node.getNext();
            Node ptr2NextNode = ptr2node.getNext();
            
            if (i != n/2 -1) {
                ptr2node.setNext(ptr1node.getNext());
            } else {
                ptr2node.setNext(null);
            }
            ptr1node.setNext(ptr2node);

            ptr1node = ptr1NextNode;
            ptr2node = ptr2NextNode;
            i++;
        }

        // Printing the re-arranged array
        node = head;
        while (node != null) {
            System.out.println(node.getData());
            node = node.getNext();
        }
    }
}

class Node {

    Object data;
    Node next = null;

    Node (Object data) {
        this.data = data;
    }

    Node (Object data, Node next) {
        this.data = data;
        this.next = next;
    }

    Object getData() {
        return this.data;
    }

    void setData(Object data) {
        this.data = data;
    }

    Node getNext() {
        return this.next;
    }

    void setNext(Node next) {
        this.next = next;
    }
}