
/**
 * Straight forward impl of finding kth element from last element using linked list
 * 
 * Running time complexity : O(N)
 * 
 */
package linkedlist;

import java.util.LinkedList;
import java.util.Scanner;

public class FindKthtolastElement {
    public static void main(String[] args) {
        Scanner sc = null;
        try {
            System.out.println("Enter the number of elements");
            sc = new Scanner(System.in);
            int n = sc.nextInt();
            if (n <= 0 || n > Integer.MAX_VALUE) {
                System.out.println("Invalid input");
                return;
            }
            System.out.println("Enter the elements");
            LinkedList<Object> elementsList = new LinkedList<Object>();
            while (elementsList.size() <= n) {
                elementsList.add(sc.nextLine());
            }
            System.out.println("Enter the element from the last to be found");
            int k = sc.nextInt();   
            if (k <= 0 || k > n) {
                System.out.println("Invalid element to be searched");
            }
            Object reqElement = elementsList.get(n - k);
            System.out.println(k + "th element from the last is :: " + reqElement.toString());
        } finally {
            sc.close();
        }
    }
}
