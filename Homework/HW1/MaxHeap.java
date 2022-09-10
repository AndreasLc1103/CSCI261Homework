package Homework.HW1;

import java.lang.Math;

public class MaxHeap {
    private int[] heap;
    private int size;
    private int maxSize;

    public MaxHeap(int maxSize) {
        this.maxSize = maxSize;
    }

    private int getParent(int cursor) {
        return (int) Math.floor((cursor - 1) / 2);
    }

    private int getLeft(int cursor) {
        return ((2 * cursor) + 1);
    }

    private int getRight(int cursor) {
        return ((2 * cursor) + 2);
    }

    private int getMax() {
        int removed = this.heap[0];
        this.heap[0] = this.heap[--size];
        sortHeap(0);
        return removed;
    }

    private boolean isLeaf(int cursor) {
        if (cursor > (size / 2) && cursor <= size) {
            return true;
        } else {
            return false;
        }
    }

    private void swap(int startLoc, int endLoc) {
        int temp;
        temp = this.heap[startLoc];
        this.heap[startLoc] = this.heap[endLoc];
        this.heap[endLoc] = temp;
    }

    private void insert(int cursor) {
        this.heap[size] = cursor;
        int currentSize = size;

        while (this.heap[currentSize] > this.heap[getParent(cursor)]) {
            swap(currentSize, getLeft(cursor));
            currentSize = getParent(cursor);
        }
        size++;
    }

    private void sortHeap(int cursor) {
        if (isLeaf(cursor)) {
            return;
        }
        if ((this.heap[cursor] < this.heap[getLeft(cursor)])
                || (this.heap[cursor] < this.heap[getRight(cursor)])) {
            if (this.heap[getLeft(cursor)] > this.heap[getRight(cursor)]) {
                swap(cursor, getLeft(cursor));
                sortHeap(getLeft(cursor));
            } else {
                swap(cursor, getRight(cursor));
                sortHeap(cursor);
            }

        }
    }
}
