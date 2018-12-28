package com.company.dataStructures_linkedLists;

import java.util.Iterator;

public class DeQueueMaster<Item> implements Iterable<Item> {
    private Node<Item> front;
    private Node<Item> rear;
    private int size_of_list;

    public DeQueueMaster() {
        this.front = null;
        this.rear = null;
        this.size_of_list = 0;
    }

    public boolean isEmpty() {
        return size_of_list == 0;
    }

    public int size() {
        return this.size_of_list;
    }

    public void addFirst(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Item to add can not be null");
        }

        Node<Item> temp = new Node<>();
        temp.setItem(item);
        temp.setPrev(null);
        temp.setNext(front);
        if (this.size() == 0) {
            rear = temp;
        } else {
            front.setPrev(temp);
        }
        front = temp;
        size_of_list++;
    }

    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Item to add can not be null");
        }

        Node<Item> temp = new Node<>();
        temp.setItem(item);
        temp.setNext(null);
        temp.setPrev(rear);
        if (this.size() == 0) {
            front = temp;
            rear = temp;
        } else {
            rear.setNext(temp);
        }

        rear = temp;
        size_of_list++;
    }

    public Item removeFirst(){
        if(this.size() == 0){
            throw new java.lang.UnsupportedOperationException("Size of the queue is zero");
        }
        Item item = front.getItem();
        front = front.getNext();
        if(this.size() == 1){
            rear = front;
        }else{
            front.setPrev(null);
        }
        --size_of_list;
        return item;
    }

    public Item removeLast(){
        if(this.size() == 0){
            throw new java.lang.UnsupportedOperationException("Size of the queue is zero");
        }
        Item item = rear.getItem();
        rear = rear.getPrev();
        if(this.size() == 1){
            front = rear;
        }else{
            rear.setNext(null);
        }
        --size_of_list;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new DeQueueMasterIterator<Item>(front);
    }

    private class DeQueueMasterIterator<Item> implements Iterator<Item> {
        Node<Item> current = null;

        public DeQueueMasterIterator(Node<Item> front) {
            this.current = front;
        }


        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = this.current.getItem();
            this.current = current.getNext();
            return item;
        }

        @Override
        public void remove() {
            throw new java.lang.UnsupportedOperationException("Not Implemented");
        }
    }
}
