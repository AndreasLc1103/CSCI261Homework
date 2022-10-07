package Homework.HW3;

import java.util.Scanner;

public class LongestIncreasingSubseqDP {

    public static int longestIncrease(int[] a, int n) {
        int[] opt = new int[n];
        int i = 0;
        int j = 0;
        for (i = 0; i < n; i++) {
            opt[i] = 1;
            for (j = 0; j < i - 1; j++) {
                if (a[j] < a[i] && opt[i] <= opt[j]) {
                    opt[i] = opt[j] + 1;
                }
            }
        }
        return opt[j];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[] values = new int[length];
        for (int i = 0; i < length; i++) {
            values[i] = sc.nextInt();
        }
        System.out.println(longestIncrease(values, length));
    }
}
