package sorting;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Insertion sort is the singleton class which performs the insertion sort on the array which is
 * present as a parameter inside the class
 * 
 * @author aarish-1867
 *
 */
public class InsertionSort {
    private static List<Integer> intArr = new ArrayList<Integer>();
    
    private static final InsertionSort INSTANCE = new InsertionSort();

    public static InsertionSort getInstance() {
        return INSTANCE;
    }
    
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
    
    public static void main(String[] args) {
       getInstance().fillArray();
       getInstance().sort();
       System.out.println("The array elements in sorted order obtained as a result of insertion sort:::!!");
       for(Integer num : intArr) {
           System.out.println(num);
       }
    }
    
    /**
     * Sorts the array using the insertion sort procedure
     * The main catch here is the efficiency obtained from the swap procedure
     * Bubbling technique is used instead of the swap per iteration
     */
    public void sort() {
        int i = 0;
        for(int j = 1 ; j < intArr.size() ; j++) {
            int key = intArr.get(j);
            i = j - 1;
            while(i >= 0 && intArr.get(i) > key) {
             intArr.set(i + 1, intArr.get(i));   
             i--;
            }
            intArr.set(i + 1, key);
        }
    }
}


