/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tonygorena
 */
public class HeapSorter {

    private String[] Heap;               //Heap array
    private int size;               //maximum size of heap
    private int n;                  //number of itmes in heap

    /**
     * Heap sort an array
     *
     * @param array the array to be sorted
     */
    public void doSort(String[] array) {
        maxHeap(array, array.length, array.length);
        for (int i = 0; i < array.length; i++) {
            removeMax();
        }
    }

    /**
     * Constructs a maxHeap object
     *
     * @param heap array
     * @param num number of items in heap
     * @param max max size of heap
     * @return the unsorted heap
     */
    private String[] maxHeap(String[] heap, int num, int max) {
        Heap = heap;
        n = num;
        size = max;
        buildHeap();
        return Heap;
    }

    /**
     * @return size of heap
     */
    private int heapSize() {
        return n;
    }

    /**
     * Determines if value is a leaf value
     *
     * @param pos the position to check
     * @return true if leaf
     */
    private boolean isLeaf(int pos) {
        return (pos >= n / 2) && (pos < n);
    }

    /**
     * @param pos position to check
     * @return Position for left child of pos
     */
    private int leftChild(int pos) {

        return 2 * pos + 1;
    }

    /**
     * @param pos position to check
     * @return Position for right child of pos
     */
    private int rightChild(int pos) {
        return 2 * pos + 2;
    }

    /**
     *
     * @param pos position to check
     * @return the position for parent
     */
    private int parent(int pos) {
        return (pos - 1) / 2;
    }

    /**
     * Insert value to heap
     *
     * @param val the value to insert
     */
    private void insert(String val) {
        int curr = n++;
        Heap[curr] = val;
        while ((curr != 0) && (Heap[curr].compareToIgnoreCase(Heap[parent(curr)]) > 0)) {
            this.swap(Heap, curr, parent(curr));
            curr = parent(curr);
        }
    }

    /**
     * Heapify contents of heap
     */
    private void buildHeap() {
        for (int i = n / 2 - 1; i >= 0; i--) {
            siftDown(i);
        }
    }

    /**
     * Put elements in correct places
     *
     * @param pos position of element to check
     */
    private void siftDown(int pos) {
        while (!isLeaf(pos)) {
            int j = leftChild(pos);
            if ((j < (n - 1)) && (Heap[j].compareToIgnoreCase(Heap[j + 1]) < 0)) {
                j++;
            }
            if (Heap[pos].compareToIgnoreCase(Heap[j]) >= 0) {
                return;
            }
            this.swap(Heap, pos, j);
            pos = j;
        }
    }

    /**
     * Remove value and return maximum value
     *
     * @return maximum value
     */
    private String removeMax() {
        this.swap(Heap, 0, --n);
        if (n != 0) {
            siftDown(0);
        }
        return Heap[n];
    }

    /**
     * Remove element and return value
     *
     * @param pos position of element to remove
     * @return element that was removed
     */
    private String remove(int pos) {
        if (pos == (n - 1)) {
            n--;
        } else {
            while ((pos > 0) && (Heap[pos].compareToIgnoreCase(Heap[parent(pos)]) > 0)) {
                this.swap(Heap, pos, parent(pos));
                pos = parent(pos);

            }
            if (n != 0) {
                siftDown(pos);
            }
        }
        return Heap[n];

    }

    public void swap(String[] array, int k, int j) {
        String kValue = array[k];
        String jValue = array[j];
        array[k] = jValue;
        array[j] = kValue;
    }
}
