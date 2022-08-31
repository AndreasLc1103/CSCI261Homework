package CSCI261Homework.Homework.Homework0;

import java.util.Scanner;

public class Primes {

    /**
     * isPrime() is a function that is responsible for
     * checking to see if with a given number we are able check if the number is
     * prime
     * if it is divisible by itself and not by other factors.
     * 
     * @return
     */
    public static boolean isPrime(int number) {
        if (number == 1) {
            return false;
        }
        if (number == 2) {
            return true;
        }
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                return false;
            } else {
                return true;
            }
        }
        return true;
    }

    public static void primeChecker(int target) {
        for (int i = 2; i <= target; i++) {
            if (isPrime(i)) {
                System.out.println(i);
            }
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // Scanner scan = new Scanner(System.in);
        // int input = scan.nextInt();
        primeChecker(17);
        // scan.close();

    }
}