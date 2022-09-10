import java.lang.Math;

public class MaxHeap {
    private int[] heap;
    private int size;
    private int maxSize;

    public MaxHeap(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        this.heap = new int[maxSize];
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

    public int getRoot() {
        return heap[0];
    }

    public int getMax() {
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

    public void insert(int input) {
        this.heap[size] = input;
        int currentSize = size;

        while (this.heap[currentSize] > this.heap[getParent(currentSize)]) {
            swap(currentSize, getLeft(currentSize));
            currentSize = getParent(input);
        }
        size++;
    }

    public void fillHeap(int[] input) {
        for (int i : input) {
            insert(i);
        }
    }

    public int getSize() {
        return size;
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
