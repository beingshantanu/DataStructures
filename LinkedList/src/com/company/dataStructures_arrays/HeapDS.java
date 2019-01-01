package com.company.dataStructures_arrays;

import com.company.util.Utility;

import java.util.Iterator;

public class HeapDS<T extends Comparable<T>> implements Iterable<T> {
    private int heap_max_size;
    private int heap_size;
    private T[] heap;

    public HeapDS(int max_size) {
        this.heap_max_size = max_size;
        this.heap_size = 0;
        this.heap = (T[]) new Comparable[heap_max_size];
    }

    public int getHeap_size() {
        return heap_size;
    }

    public void addToHeap(T key) {
        if (key == null) {
            throw new IllegalArgumentException("Key can not be null");
        }
        if (heap_size == heap_max_size - 1) {
            throw new ArrayIndexOutOfBoundsException("Max size limit of heap exceeds.");
        }
        this.heap[heap_size++] = key;
        int cur_index = this.heap_size - 1;
        this.swim(cur_index);
    }

    public T deleteFromHeap(){
        if (this.heap_size == 0) {
            throw new java.util.NoSuchElementException("Heap is Empty");
        }

        T item = heap[0];
        heap[0] = heap[this.getHeap_size() - 1];
        heap[this.getHeap_size() - 1] = null;
        --heap_size;
        int cur_index = 0;
        this.sink(cur_index);
        return item;
    }

    @Override
    public Iterator<T> iterator() {
        return new HeapDSIterator();
    }

    private class HeapDSIterator implements Iterator<T> {

        int index;

        public HeapDSIterator() {
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return index < heap_size;
        }

        @Override
        public T next() {
            T item = heap[index];
            index++;
            return item;
        }

        @Override
        public void remove() {

        }
    }

    private void swim(int cur_index) {
        int parent_index;

        while (cur_index != 0) {
            parent_index = this.getParentIndex(cur_index);
            if (!Utility.less(heap[cur_index], heap[parent_index])) {
                Utility.swap(heap, cur_index, parent_index);
                cur_index = parent_index;
            } else {
                break;
            }
        }
    }

    private void sink(int cur_index) {
        while (cur_index != (this.heap_size - 1)) {
            int max_index = cur_index;
            int left_index = this.getLeftChild(cur_index);
            int right_index = this.getRightChild(cur_index);

            if (this.hasChild(left_index) &&
                    Utility.great(heap[left_index], heap[max_index])) {
                max_index = left_index;
            }
            if (this.hasChild(right_index) &&
                    Utility.great(heap[right_index], heap[max_index])) {
                max_index = right_index;
            }

            if (max_index != cur_index) {
                Utility.swap(heap, cur_index, max_index);
                cur_index = max_index;
            } else{
                break;
            }
        }
    }

    private int getParentIndex(int cur_index) {
        return (cur_index - 1) / 2;
    }

    private int getLeftChild(int cur_index) {
        return (2 * cur_index + 1);
    }

    private int getRightChild(int cur_index) {
        return (2 * cur_index + 2);
    }

    private boolean hasChild(int cur_index) {
        return cur_index < this.heap_size;
    }

}
