package bitmanip;

/**
 * https://www.geeksforgeeks.org/count-set-bits-in-an-integer/
 * 
 * @author polymath
 *
 */
public class CountSetBitsInInteger {
	public int countBits(int n) {
		if (n == 0)
			return 0;
		int count = 0;
		while (n > 0) {
			count += n & 1;
			n >>= 1;
		}
		return count;
	}

	/**
	 * Brian karneghan's algorithm.
	 * 
	 * The basic idea of this algorithm is to find the nearest power of two
	 * It does so by subtracting 1 in every iteration
	 * 
	 * @param n
	 * @return
	 */
	public int countBitsApproachTwo(int n) {
		if (n == 0)
			return 0;
		int count = 0;
		while (n > 0) {
			n = n & (n - 1);
			count++;
		}
		return count;
	}

	/**
	 * Hashtable nibble based approach 
	 * 
	 * Run time complexity - O(logN/k) where k is nibble size
	 * Space time complexity - 2^k
	 */
	/* Recursively get nibble of a given number  
and map them in the array  */
	//int num_to_bits[16] =  {0, 1, 1, 2, 1, 2, 2, 3,   
	//		1, 2, 2, 3, 2, 3, 3, 4}; 
	//	unsigned int countSetBitsRec(unsigned int num) 
	//	{ 
	//		int nibble = 0; 
	//		if (0 == num) 
	//			return num_to_bits[0]; 
	//
	//		// Find last nibble 
	//		nibble = num & 0xf; 
	//
	//		// Use pre-stored values to find count 
	//		// in last nibble plus recursively add 
	//		// remaining nibbles. 
	//		return num_to_bits[nibble] + 
	//				countSetBitsRec(num >> 4); 
	//	} 
	//
	//	//Driver code 
	//	int main() 
	//	{ 
	//		int num = 31; 
	//		printf("%d\n", countSetBitsRec(num)); 
	//	} 
}
