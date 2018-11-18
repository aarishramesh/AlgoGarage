package binarysearch;

import java.util.ArrayList;
import java.util.List;

public class SearchForARange {
	
	static int start = -1, end = -1;
	static boolean elementFound = false;
	
	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(4); arr.add(7); arr.add(7); arr.add(8); arr.add(10); arr.add(10);
		ArrayList<Integer> result = searchRange(arr, 7);
		System.out.println("[" + start + "," + end + "]");
	}
	
	public static ArrayList<Integer> searchRange(final List<Integer> a, int b) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (a.size() == 1) {
            result.add(0); result.add(0);    
        } else {
            //rangeBinarySearch(0, a.size() - 1, a, b, -1, false);
            //result.add(start); result.add(end);
        		result.add(rangeBinarySearch(a, b, true));
        		result.add(rangeBinarySearch(a, b, false));
        		
        }
        return result;
    }
	
	public static int rangeBinarySearch(List<Integer> arr, int key, boolean searchFirst) {
		int start = 0;
	    int end = arr.size()-1;
	    int mid;
	    int result =  -1;
	    while(start <= end){
	        mid = start + (end-start)/2;
	        if(arr.get(mid) == key){
	            result = mid;
	            if(searchFirst){
	                end = mid-1;
	            }
	            else{
	                start = mid+1;
	            }
	        }
	        else if(arr.get(mid) > key){
	            end = mid-1;
	        }
	        else{ // A[mid] < key
	            start = mid+1;
	        }
	    }
	    return result;
		
	}
}
