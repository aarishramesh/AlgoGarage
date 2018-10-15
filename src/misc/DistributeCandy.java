package misc;

import java.util.ArrayList;
import java.util.Arrays;

public class DistributeCandy {

	public static int candy(ArrayList<Integer> A) {
        int n=A.size();
        int[] candies=new int[n];
        Arrays.fill(candies,1);
        for(int i=0;i<n-1;i++){
            if(A.get(i+1)>A.get(i))
                candies[i+1]=candies[i]+1;
        }
        for(int i=n-1;i>0;i--){
            if(A.get(i-1)>A.get(i) && candies[i-1]<=candies[i])
                candies[i-1]=candies[i]+1;
        }
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=candies[i];
        }
        return sum;
    }
}
