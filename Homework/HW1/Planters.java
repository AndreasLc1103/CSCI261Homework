package Homework.HW1;

import java.util.Scanner;
import Homework.HW1.MaxHeap;

public class Planters {

    public static void planters(int[] inPlanters, int[] inEmptyPlanters) {
        // Max heaps are created for both full and empty planters
        MaxHeap planters = new MaxHeap(inPlanters.length);
        MaxHeap emptyPlanters = new MaxHeap(inEmptyPlanters.length);
        // fills in the planter from the input arrays
        planters.fillHeap(inPlanters);
        emptyPlanters.fillHeap(inEmptyPlanters);

        while (planters.getSize() > 0) {
            if (planters.getRoot() < emptyPlanters.getRoot()) {
                int spot = planters.getMax();
                emptyPlanters.insert(spot);
            } else {
                System.out.println("NO");
            }
        }
        System.out.println("Yes");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int plantersCount = scanner.nextInt();
        int emptyPlantersCount = scanner.nextInt();

        int[] planters = new int[plantersCount];
        int[] emptyPlanters = new int[emptyPlantersCount];
        for (int i : planters) {
            i = scanner.nextInt();
        }
        for (int i : emptyPlanters) {
            i = scanner.nextInt();
        }
        planters(planters, emptyPlanters);

        scanner.close();
    }
}
