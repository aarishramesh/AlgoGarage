package trees;

public class BinarySearchTreeFromArray {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 12, 21, 32, 33, 76, 89, 91};
        boolean elementFound = false;
        int minIndex = 0, temp = 0;
        
        //Sorting logic - inefficient with O (N ^ 2) running time
        for(int i = 0; i < arr.length; i++) {
            minIndex = i;
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[j] <= arr[minIndex]) {
                    minIndex = j;
                }
            }
            temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    
    //Sorted array is given as input for binary search
        int i = 0, mid = 0;
        int j = arr.length, element = 76;
        int n = logCalculator(arr.length);
        while(n > 0) {
            mid = (i + j)/2;
            if(element == arr[mid]) {
                elementFound = true;
                break;
            } else if(element < arr[mid]) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
            n--;
        }
        
    //Printing the result of Binary search for the element 7
        System.out.println(elementFound);
    }
    
    //Method to calculate log to the base 2
    static int logCalculator(int num) {
        int n = 0;
        while(num > 0) {
            num = num / 2;
            n++;
        }
        return n;
    }
}
