package Homework.HW4;

import java.util.Scanner;

public class LongestKindOfIncrSubseq {

    public static int LongestKinda(int[] nValues) {
        // this will store the preivous entries
        int opt[][] = new int[nValues.length][nValues.length];

        for (int i = 0; i < nValues.length; i++) {
            for (int j = i + 1; j < nValues.length; j++) {
                for (int k = 0; k < i - 1; k++) {
                    double average = (nValues[k] + nValues[i]) / 2;
                        if ((average) < nValues[j]) {
                            
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();
        int[] matrix = new int[input];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scan.nextInt();
        }

    }
}