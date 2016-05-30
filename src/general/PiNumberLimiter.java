package general;

import java.util.Scanner;

public class PiNumberLimiter {
    public static void main(String[] args) {
        System.out.println("Enter the number of digits of decimal for PI:: ");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        double flooredPi = Math.floor(Math.PI * Math.pow(10, num));
        double reqVal = flooredPi / Math.pow(10, num);
        System.out.println("Truncated value is::" + reqVal);
        sc.close();
    }
}
