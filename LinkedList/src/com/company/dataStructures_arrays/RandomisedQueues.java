package com.company.dataStructures_arrays;

import java.util.Iterator;
import java.util.Random;

public class RandomisedQueues<Item> implements Iterable<Item> {
    private int size_of_queue;
    private Item[] queue;

    public RandomisedQueues() {
        this.size_of_queue = 0;
        this.queue = (Item[]) new Object[1];
    }

    public boolean isEmpty() {
        return this.size_of_queue == 0;
    }

    public int size() {
        return this.size_of_queue;
    }

    public void enqueue(Item item) {
        if (item == null) {
            throw new java.lang.IllegalArgumentException("Item to insert can not be null");
        }
        queue[size_of_queue++] = item;
        if (queue.length == size_of_queue) {
            this.resize(2 * size_of_queue);
        }
    }

    public Item deQueue() {
        if (this.size() == 0) {
            throw new java.util.NoSuchElementException("Queue is Empty");
        }

        int rand_index = new Random().nextInt(size_of_queue);
        Item item = queue[rand_index];
        queue[rand_index] = queue[size_of_queue - 1];
        queue[size_of_queue - 1] = null;
        --size_of_queue;
        if (size_of_queue > 0 && size_of_queue == (queue.length / 4)) {
            resize(2 * size_of_queue);
        }
        return item;
    }

    public Item sample() {
        if (this.size() == 0) {
            throw new java.util.NoSuchElementException("Queue is Empty");
        }
        Random random = new Random();
        int rand_index = random.nextInt(size_of_queue);
        return queue[rand_index];
    }

    @Override
    public Iterator<Item> iterator() {
        return new RandomisedQueueIterator(this.size_of_queue);
    }

    private class RandomisedQueueIterator implements Iterator<Item> {
        private int sizeOfQueue = 0;
        private Item[] temp;

        public RandomisedQueueIterator(int size) {
            this.sizeOfQueue = size;
            this.temp = (Item[]) new Object[this.sizeOfQueue];
            for (int i = 0; i < sizeOfQueue; i++) {
                this.temp[i] = queue[i];
            }
        }

        @Override
        public boolean hasNext() {
            return sizeOfQueue != 0;
        }

        @Override
        public Item next() {
            Random random = new Random();
            int random_index = random.nextInt(sizeOfQueue);
            Item item = temp[random_index];
            temp[random_index] = temp[sizeOfQueue - 1];
            temp[sizeOfQueue - 1] = null;
            --sizeOfQueue;
            return item;
        }

        @Override
        public void remove() {
            throw new java.lang.UnsupportedOperationException("Unsupported Method");
        }
    }

    private void resize(int size) {
        Item[] temp = (Item[]) new Object[size];
        for (int i = 0; i < this.size(); i++) {
            temp[i] = queue[i];
        }
        queue = temp;
    }
}
