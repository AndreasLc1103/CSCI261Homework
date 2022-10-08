package Homework.HW3;

import java.util.Scanner;

public class LongestIncreasingSubseqDP {
    public static int longestIncrease(int[] a, int n) {
        int[] opt = new int[n + 1];
        for (int j = 1; j <= n; j++) {
            opt[j] = 1;
            for (int k = 1; k < (j - 1); k++) {
                if (a[k] < a[j] && opt[j] <= opt[k]) {
                    opt[j] = opt[k] + 1;
                }
            }
        }
        return opt[opt.length - 1];
    }

    static int lis(int arr[], int n) {
        int lis[] = new int[n];
        int i, j, max = 0;

        /* Initialize LIS values for all indexes */
        for (i = 0; i < n; i++)
            lis[i] = 1;

        /* Compute optimized LIS values in bottom up manner */
        for (i = 1; i < n; i++)
            for (j = 0; j < i; j++)
                if (arr[i] > arr[j] && lis[i] < lis[j] + 1)
                    lis[i] = lis[j] + 1;

        /* Pick maximum of all LIS values */
        for (i = 0; i < n; i++)
            if (max < lis[i])
                max = lis[i];

        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[] values = new int[length];
        for (int i = 0; i < length; i++) {
            values[i] = sc.nextInt();
        }
        // System.out.println(longestIncrease(values, length));
        System.out.println(lis(values, length));
    }
}
