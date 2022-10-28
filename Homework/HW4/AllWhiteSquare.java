package Homework.HW4;

import java.util.Scanner;

public class AllWhiteSquare {

    public static boolean checkIfWhite(char input) {
        return input == 'w' ? true : false;
    }

    public static int getLargestWhiteSquare(char[][] inputMatrix, int gridSize) {
        int optLength = gridSize + 1;
        int[][] opt = new int[optLength][optLength];
        for (int i = 1; i < optLength; i++) {
            for (int j = 1; j < opt.length; j++) {
                if (checkIfWhite(inputMatrix[i][j])) {
                    opt[i][j] = 1 + Math.min(Math.min(opt[i][j - 1], opt[i - 1][j - 1]), opt[i - 1][j]);
                } else {
                    opt[i][j] = 0;
                }
            }
        }
        return opt[optLength - 1][optLength - 1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputSize = scanner.nextInt();
        char[][] grid = new char[inputSize][inputSize];
        for (int i = 0; i < grid.length; i++) {
            String line = scanner.nextLine();
            grid[i] = line.toCharArray();
        }
        System.out.println(getLargestWhiteSquare(grid, inputSize));
    }
}