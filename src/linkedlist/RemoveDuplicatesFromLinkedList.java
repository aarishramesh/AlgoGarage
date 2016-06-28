package linkedlist;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Remove duplicates from linked list can be achieved by two techniques
 * 
 * 1. Hash table based approach
 * 
 *    Time complexity - O(1) 
 *    Space complexity - O(n) - Additional hashtable is used. If single threaded then hashmap can also be used to avoid
 *      synchronization overhead
 * 
 * 2. Pointer based approach
 *    This technique makes use of two pointers checking for whether every element is duplicated
 *    Inefficient but in-place
 *    
 *    Time complexity - O(n^2)
 *    Space complexity -  O(1)
 * 
 * @author aarish
 *
 */
public class RemoveDuplicatesFromLinkedList {
    public static void main(String[] args) {

        System.out.println("Check duplicates in a linked list dynamically. Enter end to stop entering elements to the list");
        Scanner sc = new Scanner(System.in);

        List<String> valuesList = new LinkedList<String>();
        Map<String, Integer> entityVsCount = new Hashtable<String, Integer>();
        boolean dupFound = false;
        
        //Check for position for duplicate element
        String val = null;
        while (!(val = sc.nextLine()).equals("end")) {
            valuesList.add(val);
            Integer count = entityVsCount.get(val);
            if (count != null && count > 0) {
                System.out.println("Duplicate found while entering " + valuesList.size() + " element");
                dupFound = true;
                break;
            } else {
                entityVsCount.put(val, new Integer(1));
            }
        }  
        if (valuesList.isEmpty()) {
            System.out.println("No elements entered");
        } else if (!dupFound) {
            System.out.println("Duplicate not found");
        }
        
        System.out.println("-- Printing the values of linked list --");
        for (Object obj : valuesList) {
            System.out.println(obj);
        }
        sc.close();
    }
}
