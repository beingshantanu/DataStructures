package com.company.dataStructures_arrays;

import com.company.util.Utility;

import java.util.Iterator;

public class PriorityQueueDS<T> implements Iterable<PriorityQueue> {
    PriorityQueue<T>[] PQ;
    int max_size;
    int cur_size;

    public PriorityQueueDS(int max_size) {
        this.max_size = max_size;
        this.cur_size = 0;
        this.PQ = new PriorityQueue[max_size];
    }

    public int getSize() {
        return this.cur_size;
    }

    public void addToQueue(T key, int priority) {
        if (key == null) {
            throw new IllegalArgumentException("Item to insert can not be null");
        }
        PriorityQueue<T> pqItem = new PriorityQueue<>();
        pqItem.setKey(key);
        pqItem.setPriority(priority);
        PQ[cur_size++] = pqItem;
        int cur_index = cur_size - 1;
        this.swim(cur_index);
    }

    public PriorityQueue deleteFromQueue() {
        if (this.cur_size == 0) {
            throw new java.util.NoSuchElementException("Queue is Empty");
        }
        PriorityQueue pqItem = new PriorityQueue<>();
        pqItem.setKey(PQ[0].getKey());
        pqItem.setPriority(PQ[0].getPriority());
        PQ[0] = PQ[cur_size - 1];
        PQ[cur_size - 1] = null;
        --cur_size;
        this.sink(0);
        return pqItem;
    }

    @Override
    public Iterator<PriorityQueue> iterator() {
        return new PriorityQueueDSIterator();
    }

    private class PriorityQueueDSIterator implements Iterator<PriorityQueue> {
        int cur_index;

        public PriorityQueueDSIterator() {
            this.cur_index = 0;
        }


        @Override
        public boolean hasNext() {
            return this.cur_index <= cur_size - 1;
        }

        @Override
        public PriorityQueue next() {
            PriorityQueue priorityQueue = new PriorityQueue();
            priorityQueue.setKey(PQ[this.cur_index].getKey());
            priorityQueue.setPriority(PQ[this.cur_index].getPriority());
            ++this.cur_index;
            return priorityQueue;
        }

        @Override
        public void remove() {

        }
    }

    private void swim(int cur_index) {
        while (cur_index != 0) {
            int parent_index = this.getParentIndex(cur_index);
            if (Utility.less(PQ[cur_index].getPriority(),
                    PQ[parent_index].getPriority())) {
                this.swap(cur_index, parent_index);
                cur_index = parent_index;
            } else {
                break;
            }
        }
    }

    private void sink(int cur_index) {
        while (true) {
            int left_index = this.getLCIndex(cur_index);
            int right_index = this.getRCIndex(cur_index);
            int high_index = cur_index;
            int high_priority = PQ[cur_index].getPriority();

            if (PQ[left_index] != null &&
                    Utility.less(PQ[left_index].getPriority(),
                            high_priority)) {
                high_index = left_index;
                high_priority = PQ[left_index].getPriority();
            }
            if (PQ[right_index] != null &&
                    Utility.less(PQ[right_index].getPriority(),
                            high_priority)) {
                high_index = right_index;
                high_priority = PQ[right_index].getPriority();
            }

            if (high_index != cur_index) {
                this.swap(cur_index, high_index);
                cur_index = high_index;
            } else {
                break;
            }
        }

    }

    private void swap(int cur_index, int parent_index) {
        PriorityQueue temp = this.PQ[cur_index];
        this.PQ[cur_index] = this.PQ[parent_index];
        this.PQ[parent_index] = temp;
    }

    private int getParentIndex(int cur_index) {
        return (cur_index - 1) / 2;
    }

    private int getLCIndex(int cur_index) {
        return (2 * cur_index + 1);
    }

    private int getRCIndex(int cur_index) {
        return (2 * cur_index + 2);
    }
}
