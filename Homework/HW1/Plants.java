package Homework.HW1;

import java.util.Scanner;

public class Plants {

    public static void planters() {

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int plantersCount = scanner.nextInt();
        int emptyPlantersCount = scanner.nextInt();

        int[] planters = new int[plantersCount];
        int[] emptyPlanters = new int[emptyPlantersCount];

        scanner.close();
    }
}
