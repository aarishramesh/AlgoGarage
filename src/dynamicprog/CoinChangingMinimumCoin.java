package dynamicprog;

import java.util.Map;

public class CoinChangingMinimumCoin {
	
	 /**
     * Top down dynamic programing. Using map to store intermediate results.
     * Returns Integer.MAX_VALUE if total cannot be formed with given coins
     */
    public int minimumCoinTopDown(int total, int coins[], Map<Integer, Integer> map) {

        //if total is 0 then there is nothing to do. return 0.
        if ( total == 0 ) {
            return 0;
        }

        //if map contains the result means we calculated it before. Lets return that value.
        if ( map.containsKey(total) ) {
            return map.get(total);
        }

        //iterate through all coins and see which one gives best result.
        int min = Integer.MAX_VALUE;
        for ( int i=0; i < coins.length; i++ ) {
            //if value of coin is greater than total we are looking for just continue.
            if( coins[i] > total ) {
                continue;
            }
            //recurse with total - coins[i] as new total
            int val = minimumCoinTopDown(total - coins[i], coins, map);

            //if val we get from picking coins[i] as first coin for current total is less
            // than value found so far make it minimum.
            if( val < min ) {
                min = val;
            }
        }

        //if min is MAX_VAL dont change it. Just result it as is. Otherwise add 1 to it.
        min =  (min == Integer.MAX_VALUE ? min : min + 1);

        //memoize the minimum for current total.
        map.put(total, min);
        return min;
    }
    
	public static int minCoinChanges(int total, int[] coins) {
		int[] T = new int[total + 1];
		int[] R = new int[total + 1];
		for (int i = 0; i < T.length; i++) {
			T[i] = Integer.MAX_VALUE - 1;
			R[i] = -1;
		}
		T[0] = 0;
		for(int i = 0; i < coins.length; i++) {
			for (int j = 1; j < T.length; j++) {
				if (j >= coins[i]) {
					if (T[j - coins[i]] + 1 < T[j]) {
						T[j] = T[j - coins[i]] + 1;
						R[j] = i;
					}
				}
			}
		}
        printCoinCombination(R, coins);
        return T[total];
	}
	
	static void printCoinCombination(int[] R, int[] coins) {
		if (R[R.length - 1] == -1) {
            System.out.print("No solution is possible");
            return;
        }
        int start = R.length - 1;
        System.out.print("Coins used to form total ");
        while ( start != 0 ) {
            int j = R[start];
            System.out.print(coins[j] + " ");
            start = start - coins[j];
        }
        System.out.print("\n");
	}

}
