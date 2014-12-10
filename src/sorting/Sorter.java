package sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Abstract sorter which sorts the given list of elements
 * This sorter has to be extended for concrete implementation
 * 
 * @author aarish-1867
 *
 */
public abstract class Sorter {
    protected List<Integer> intArr = new ArrayList<Integer>();

    public void fillArray() {
        System.out.println("Enter the size of array");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), i = 0;
        System.out.println("Enter the array elements::");
        while(i < n) {
            intArr.add(i, sc.nextInt());
            i++;
        }
        System.out.println("Data collection completed successfully!!");
    }
    
    public void sort() {
        
    }
    
    public void printSortedArray() {
        System.out.println("The sorted array is::");
        for(Integer num : intArr) {
            System.out.println(num);
        }
    }
}
