package sorting;

/**
 * Insertion sort is the singleton class which performs the insertion sort on the array which is
 * present as a parameter inside the class
 * 
 * Best case running time is O(n) when the elements are already sorted, the inner loop doesn't get executed
 * Proof - CLRS page 
 * 
 * Worst case running time is O(n^2) 
 * 
 * @author AARISH
 *
 */
public class InsertionSorter extends Sorter {
    
    private static final InsertionSorter INSTANCE = new InsertionSorter();

    public static InsertionSorter getInstance() {
        return INSTANCE;
    }
    
    public static void main(String[] args) {
       getInstance().fillArray();
       getInstance().sort();
       System.out.println("The array elements in sorted order obtained as a result of insertion sort:::!!");
       getInstance().printSortedArray();
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


