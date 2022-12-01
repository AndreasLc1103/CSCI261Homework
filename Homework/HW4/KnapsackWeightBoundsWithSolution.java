package Homework.HW4;

import java.util.Scanner;

public class KnapsackWeightBoundsWithSolution {

    private static void printKnapsackItems(int[][] opt, int n, int w, int res, int[] weights, int[] costs) {
        for (int i = n; i > 0 && res > 0; i--) {
            if (res == opt[i - 1][w]) {
            } else {
                res = res - costs[i - 1];
                w = w - weights[i - 1];
                System.out.println(res + " ");
            }
        }

    }

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
        int max = Integer.MIN_VALUE;
        int index = 0;
        // max of the range of values if needed.
        for (int i = weight1; i < weight2; i++) {
            if (opt[len][i] > max) {
                max = opt[len][i];
                index = i;
            }
        }
        System.out.println(max);
        int w = weight2;

        printKnapsackItems(opt, index - 1, weight2, max, weights, costs);

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