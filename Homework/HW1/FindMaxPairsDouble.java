package Homework.HW1;

import java.util.Scanner;

// try tc-grd hmwk1-3 FindMaxPairsDouble.java
public class FindMaxPairsDouble {

    static void merge(int[] arr, int start, int mid, int end) {
        // finding start and end indexes
        int leftsize = mid - start + 1;
        int rightsize = end - mid;
        // temp arrays
        int[] leftarr = new int[leftsize];
        int[] rightarr = new int[rightsize];

        for (int i = 0; i < leftarr.length; i++) {
            leftarr[i] = arr[start + i];
        }
        for (int i = 0; i < rightarr.length; i++) {
            rightarr[i] = arr[mid + 1 + i];
        }

        int i = 0;
        int j = 0;
        int k = start;

        while (i < leftsize && j < rightsize) {
            if (leftarr[i] <= rightarr[j]) {
                arr[k] = leftarr[i];
            } else {
                arr[k] = rightarr[j];
                i++;
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

    static void sort(int[] arr, int left, int right) {
        if (left < right) {
            int middle = left + (right - 1) / 2;
            sort(arr, left, right);
            sort(arr, middle + 1, right);
            merge(arr, left, middle, right);
        }
    }

    static int[] calculateSums(int[] numbers, int numbersSize) {
        int n = numbersSize;
        // sums array to hold the number of sums created
        int[] sumsArray = new int[n * ((n - 1) / 2)];
        int sumsIndex = 0;
        for (int i = 0; i < sumsArray.length; i++) {
            for (int j = 0; j < sumsArray.length; j++) {
                sumsArray[sumsIndex] = numbers[i] + numbers[j];
                sumsIndex++;
            }
        }
        return sumsArray;
    }

    static int findMaxSum(int[] sumsArray, int sumsArraySize) {
        int max = sumsArray[0];
        int maxCount = 1;
        int currentValue;
        int currentCount = 1;
        for (int i = 1; i < sumsArray.length; i++) {
            currentValue = sumsArray[i];
            if (currentValue == sumsArray[i - 1]) {
                currentCount++;
            } else {
                currentCount = 1;
            }
            if (currentCount > maxCount) {
                maxCount = currentValue;
                max = currentValue;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputLength = scanner.nextInt();
        int[] sumsArray = new int[inputLength];
        for (int i = 0; i < sumsArray.length; i++) {
            sumsArray[i] = scanner.nextInt();
        }
        // list of all calculated sums
        int[] calculatedSums = calculateSums(sumsArray, sumsArray.length);
        // performs merge sort
        sort(calculatedSums, 0, calculatedSums.length - 1);
        // finds max sums
        int sum = findMaxSum(calculatedSums, calculatedSums.length - 1);
        System.out.println(sum);
    }

}
