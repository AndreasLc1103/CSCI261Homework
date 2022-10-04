package Homework.HW1;

import java.util.Scanner;

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
<<<<<<< Updated upstream
               int value = planters.getMax();
=======
                int value = planters.getMax();
>>>>>>> Stashed changes
                emptyPlanters.getMax();
                emptyPlanters.insert(value);
            } else {
                System.out.println("NO");
                break;
            }
        }
        if (planters.getSize() == 0) {
            System.out.println("YES");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int plantersCount = scanner.nextInt();
        int emptyPlantersCount = scanner.nextInt();

        int[] planters = new int[plantersCount];
        int[] emptyPlanters = new int[emptyPlantersCount];
        for (int i = 0; i < planters.length - 1; i++) {
            planters[i] = scanner.nextInt();
        }
        for (int i = 0; i < emptyPlanters.length - 1; i++) {
            emptyPlanters[i] = scanner.nextInt();
        }
        planters(planters, emptyPlanters);

        scanner.close();
    }
}
