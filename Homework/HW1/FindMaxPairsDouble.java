<<<<<<< Updated upstream
=======
package Homework.HW1;


>>>>>>> Stashed changes
import java.util.Scanner;

// try tc-grd hmwk1-3 FindMaxPairsDouble.java
public class FindMaxPairsDouble {

    static void merge(double[] arr, int start, int mid, int end) {
        // finding start and end indexes
        int leftsize = mid - start + 1;
        int rightsize = end - mid;
        // temp arrays
        double[] leftarr = new double[leftsize];
        double[] rightarr = new double[rightsize];

        for (int i = 0; i < leftsize; i++) {
            leftarr[i] = arr[start + i];
        }
        for (int i = 0; i < rightsize; i++) {
            rightarr[i] = arr[mid + 1 + i];
        }

        int i = 0;
        int j = 0;
        int k = start;

        while (i < leftsize && j < rightsize) {

            if (leftarr[i] <= rightarr[j]) {
                arr[k] = leftarr[i];
                i++;
            } else {
                arr[k] = rightarr[j];
                j++;
            }
            k++;
        }

        while (i < leftsize) {
            arr[k] = leftarr[i];
            i++;
            k++;
        }
        while (j < rightsize) {
            arr[k] = rightarr[j];
            j++;
            k++;
        }

    }

    static void sort(double[] arr, int left, int right) {
        if (left < right) {
            int middle = left + (right - left) / 2;

            sort(arr, left, middle);

            sort(arr, middle + 1, right);
            merge(arr, left, middle, right);
        }
    }

    static double[] calculateSums(double[] numbers, int numbersSize) {
        int n = numbersSize;
        // sums array to hold the number of sums created
        double[] sumsArray = new double[(int) ((n * (n - 1)) / 2)];
        int sumsIndex = 0;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                sumsArray[sumsIndex] = numbers[i] + numbers[j];
                sumsIndex++;
            }
        }
        return sumsArray;
    }

    static double[] findMaxSum(double[] sumsArray, int sumsArraySize) {
        double max = sumsArray[0];
        double maxCount = 1;
        double currentValue;
        double currentCount = 1;
        for (int i = 1; i <= sumsArraySize; i++) {
            currentValue = sumsArray[i];
            if (currentValue == sumsArray[i - 1]) {
                currentCount++;
            } else {
                currentCount = 1;
            }
            if (currentCount > maxCount) {
                maxCount = currentCount;
                max = currentValue;
            }
        }
        double[] output = new double[2];
        output[0] = maxCount;
        output[1] = max;
        return output;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputLength = scanner.nextInt();
        double[] sumsArray = new double[inputLength];
        for (int i = 0; i < sumsArray.length; i++) {
            sumsArray[i] = scanner.nextDouble();
        }
        // list of all calculated sums
        double[] calculatedSums = calculateSums(sumsArray, sumsArray.length);
        // performs merge sort
        sort(calculatedSums, 0, calculatedSums.length - 1);
        // finds max sums
        double[] out = findMaxSum(calculatedSums, calculatedSums.length - 1);
        System.out.println((int) out[0] + " " + String.format("%.6f", out[1]));
    }

}
