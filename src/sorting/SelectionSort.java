package sorting;
import java.util.Scanner;

/*
 * Difference between selection and insertion sort is that selection keeps growing its list of sorted elements
 * whereas insertion sort collapses its list of sorted elements whenever a new element is added to the list
 * 
 * Both have an worst running times of O(n^2) -  n operations for comparing and n operations for swapping for worst case scenario 
 * and best running times of O(n) - i.e elements are in sorted order already therefore only n comparisons and no sorting
 */
public class SelectionSort {
	
	static int n; static int[] arrList;
	
	public static void main(String[] args) {
		Scanner inp = new Scanner(System.in);
		System.out.println("Enter the number of elements");
		n = inp.nextInt();
		int i, j, min = 0;
		arrList = new int[n];
		
		for(i = 0; i < n; i++) {
			arrList[i] = inp.nextInt();
		}
		
		for(i = 0; i < n; i++) {
			min = arrList[i];
			for(j = i+1; j < n; j++) {
				if(arrList[j] <= min) {
					swap(j, i);
					min = arrList[i];
				}
			}
		}
		
		System.out.println("The elements in sorted order is:");
		for(i = 0; i < n; i++) {
			System.out.println(arrList[i]);
		}
	}
	
	static void swap(int fromPos, int toPos) {
		int temp = arrList[fromPos];
		arrList[fromPos] = arrList[toPos];
		arrList[toPos] = temp;
	}
}
