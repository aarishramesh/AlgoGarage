package arraysstrings;

import java.util.Scanner;

/**
 * Rotate a N*N matrix by 90* in place
 * 
 * Run time complexity - 
 * 
 * Space complexity - In place so no additional space is required
 * 
 * @author aarish-1867
 *
 */
public class MatrixRotation {

    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter matrix's size : ");
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println("Enter (" + i + "," + j + ") element");
                matrix[i][j] = sc.nextInt();
            }
        }
        sc.close();

        System.out.println("\n Printing elements of matrix in proper format before rotation \n");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j]);
                if (j < n - 1) {
                    System.out.print("  ");
                }
            }
            System.out.print("\n");
        }

        rotateMatrixBy90(matrix);

        System.out.println("\n Printing elements of matrix in proper format after rotation by 90 * \n");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j]);
                if (j < n - 1) {
                    System.out.print("  ");
                }
            }
            if (i != n - 1) {
                System.out.print("\n");
            }
        }
    }

    static void rotateMatrixBy90(int[][] matrix) {
        int length = matrix.length;
        int layers = matrix.length/2;
        for (int i = 0; i < layers; i++) {
            for (int offset = 0; offset < length - 1 - (i * 2); offset++) {
                int temp = matrix[i][i + offset];
                matrix[i][i + offset] = matrix[length - 1 - i - offset][i];
                matrix[length - 1 - i - offset][i] = matrix[length - 1 - i][length - 1 - i - offset];
                matrix[length - 1 - i][length - 1 - i - offset] = matrix[i + offset][length - 1 - i];
                matrix[i + offset][length - 1 - i] = temp;
            }
        }
    }
}
