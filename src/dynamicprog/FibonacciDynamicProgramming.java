package dynamicprog;

import java.util.Scanner;

public class FibonacciDynamicProgramming {

    static int[] fibonacciArr;

    public static void main(String[] args) {
        System.out.println("Fibonacci series sum calculation using dynamic programming");
        System.out.println("Input any of the numbers");
        System.out.println("1 - topDownApproach : 2 - memoization based approach");
        Scanner sc = null;
        try {
            sc = new Scanner(System.in);
            for (int j = 0; j < 3; j++) {
                int n = sc.nextInt();
                if (!(n == 1 || n == 2)) {
                    System.out.println("Please enter valid input");
                    if (j == 2) {
                        System.out.println("You have exhausted maximum number of choices");
                    }
                    return;
                }
                System.out.println("Number until which fibonacci sum is to be calculated ?");
                int num = sc.nextInt();
                if (num > 0 && num != Integer.MAX_VALUE) {
                    if (num == 1) {
                        System.out.println("Fibonacci sum : 1");
                        return;
                    }
                    int result;
                    if (n == 1) {
                        result = topDownApproach(num);
                    } else {
                        //In memoization based approach input is passed by decreasing 1
                        // so as to generate sum for n numbers i.e 0 to n-1 numbers
                        fibonacciArr = new int[num - 1];
                        result = fibonacciSum(num - 1);
                    }
                    System.out.println("Fibonacci sum for first " + num + " numbers :: " + result);
                } else {
                    System.out.println("Invalid number entered");
                }
            }
        } finally {
            sc.close();
        }
    }


    static int topDownApproach(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int[] fibonacciArr = new int[n];
        fibonacciArr[1] = 1;
        for (int i = 2; i < n; i++) {
            fibonacciArr[i] = fibonacciArr[i - 1] + fibonacciArr[i - 2];
        }
        return fibonacciArr[n - 1];
    }

    static int fibonacciSum(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        fibonacciArr[n - 1] = fibonacciArr[n - 1] != 0 ? fibonacciArr[n - 1] : fibonacciSum(n - 1);
        fibonacciArr[n - 2] = fibonacciArr[n - 2] != 0 ? fibonacciArr[n - 2] : fibonacciSum(n - 2);
        return fibonacciArr[n - 1] + fibonacciArr[n - 2];
    }
}
