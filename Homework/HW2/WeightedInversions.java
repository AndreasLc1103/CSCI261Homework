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
    public static Object[] merge() {

        return new Object[0];
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
