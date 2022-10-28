package Homework.HW4;

import java.util.Arrays;
import java.util.Scanner;

public class KnapsackWeightBoundsWithSolution {
    public static void knapsack(int[] weights, int[] costs, int weight1, int weight2) {
        int len = weights.length;
        int[][] opt = new int[len + 1][weight2 + 1];

        for (int i = 0; i <= len; i++) {
            for (int j = 1; j <= weight2; j++) {
                int profit = 0;
                int profit2 = 0;
                if (i == 0 || j == 0)
                    opt[i][j] = 0;
                else if (weights[i - 1] <= j) {
                    profit = costs[i - 1] + opt[i - 1][j - weights[i - 1]];
                    profit2 = opt[i - 1][j];
                    opt[i][j] = Math.max(profit, profit2);
                }
            }
        }
        for (int[] a : opt) {
            System.out.println(Arrays.toString(a));
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] inputs = scan.nextLine().split(" ");
        int length = Integer.parseInt(inputs[0]);
        int[] costs = new int[length];
        int[] weights = new int[length];
        for (int i = 0; i < length; i++) {
            String[] temp = scan.nextLine().split(" ");
            costs[i] = Integer.parseInt(temp[1]);
            weights[i] = Integer.parseInt(temp[0]);
        }
        knapsack(weights, costs, Integer.parseInt(inputs[1]), Integer.parseInt(inputs[2]));
    }
}