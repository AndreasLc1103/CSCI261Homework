package Homework.HW3;

import java.util.Scanner;

public class Donut {

    /**
     * meanLocation() is responsible for calculating the mean to find
     * the best suited location to place a donut shop.
     * 
     * @return int of the mean calculated value
     */
    public static int meanLocation(int[] inputArray) {
        int sum = 0;
        for (int i : inputArray) {
            sum += i;
        }
        return (int) Math.floor(sum / inputArray.length);
    }

    /**
     * Calculate sum simulates the given equation by problem #2 on the homework.
     * this allows us to be able to look at the values that are leading to it and
     * calculate
     * the given value
     * 
     * @param xArray    int array holding input values
     * @param yArray    int array holding input values
     * @param arrlength int of the size
     * @return returns smalles sum
     */
    public static int calculateSum(int[] xArray, int[] yArray, int arrlength) {
        int sum = 0;
        int bestX = meanLocation(xArray);
        int betsY = meanLocation(yArray);
        for (int i = 0; i < arrlength; i++) {
            sum += (Math.abs(bestX - xArray[i]) + Math.abs(betsY - yArray[i]));
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] xValues = new int[length];
        int[] yValues = new int[length];
        for (int i = 0; i < length; i++) {
            xValues[i] = scanner.nextInt();
            yValues[i] = scanner.nextInt();
        }
        System.out.println(calculateSum(xValues, yValues, length));
    }

}
