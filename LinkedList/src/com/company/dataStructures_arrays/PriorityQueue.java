package com.company.dataStructures_arrays;

public class PriorityQueue<T> {
    private T key;
    private int priority;

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
