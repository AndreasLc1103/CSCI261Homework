package Homework.HW2;

import java.util.Scanner;

import Homework.HW1.MergeSort;

class Entry {

    private int initialIndex;
    private int value;

    public Entry(int start, int value) {
        this.initialIndex = start;
        this.value = value;
    }

    public int getInitialIndex() {
        return initialIndex;
    }

    public int getValue() {
        return value;
    }

}

public class WeightedInversions {
    public static Object[] merge(Entry[] left, Entry[] right) {
        Entry[] finaldata = new Entry[left.length + right.length];
        int leftCursor = 0;
        int rightCursor = 0;
        int count = 0;
        // performs weight calculations
        for (int i = 0; i < finaldata.length; i++) {
            // case that the value in the left array is greater
            if (left[leftCursor].getValue() > right[rightCursor].getValue()) {
                count += Math.abs(right[rightCursor].getInitialIndex() - left[leftCursor].getInitialIndex());
                rightCursor += 1;
                // case value in the left array is less
            } else {
                count += Math.abs(right[rightCursor].getInitialIndex() - left[leftCursor].getInitialIndex());
                leftCursor += 1;
            }
            // regular merge process
            int x = 0, y = 0, z = 0;
            while (x < left.length && y < right.length) {
                if (left[x].getValue() <= right[y].getValue()) {
                    finaldata[z] = left[i];
                    x++;
                } else {
                    finaldata[z] = right[y];
                    y++;
                }
            }
            
        }
        return new Object[];
    }

    public static Object[] mergeSort() {
        return new Object[0];
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        int index = 0;
        Entry[] entries = new Entry[size];
        for (int i = 0; i < entries.length; i++) {
            entries[i] = new Entry(index, scan.nextInt());
            index++;
        }

    }

}
