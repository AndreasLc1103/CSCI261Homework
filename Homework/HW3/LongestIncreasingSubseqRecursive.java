package Homework.HW3;

import java.util.Scanner;

public class LongestIncreasingSubseqRecursive {

    private int longHold;

    public int getLongHold() {
        return longHold;
    }

    public void setLongHold(int longHold) {
        this.longHold = longHold;
    }

    private int recLongestISequence(int[] arr, int n) {
        // basecase
        if (n == 1) {
            return 1;
        }
        int result;
        int maxEnd = 1;

        for (int i = 1; i < n; i++) {
            result = recLongestISequence(arr, i);
            if (arr[i - 1] < arr[n - 1] && result + 1 > maxEnd) {
                maxEnd = result + 1;
            }
        }
        if (longHold < maxEnd) {
            longHold = maxEnd;
        }
        return maxEnd;
    }

    public int longestSubsequenceCounter(int[] arr, int size) {
        longHold = 1;
        recLongestISequence(arr, size);
        return longHold;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[] values = new int[length];
        for (int i = 0; i < length; i++) {
            values[i] = sc.nextInt();
        }
        LongestIncreasingSubseqRecursive sub = new LongestIncreasingSubseqRecursive();
        int calculatedValue = sub.longestSubsequenceCounter(values, length);
        System.out.println(calculatedValue);

    }
}
