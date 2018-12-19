package com.company.linkedList;

import java.util.Iterator;

public class QueueMaster<Item> implements Iterable<Item> {

    private Node<Item> front = null;
    private Node<Item> rear = null;

    public void enQueue(Item item) {
        Node<Item> current = new Node<>();
        current.setItem(item);
        current.setLink(null);

        if (isEmpty()) {
            this.front = current;
            this.rear = current;
        } else {
            this.rear.setLink(current);
            this.rear = current;
        }
    }

    public Item deQueue() {
        Item item = null;

        if (this.front != null) {
            item = this.front.getItem();
            this.front = this.front.getLink();
            if (isEmpty()) {
                front = rear = null;
            }
        }
        return item;
    }

    private boolean isEmpty() {
        return this.front == null;
    }

    @Override
    public Iterator<Item> iterator() {
        return new QueueMasterIterator<Item>(this.front);
    }

    private class QueueMasterIterator<Item> implements Iterator<Item> {

        Node<Item> current;

        public QueueMasterIterator(Node<Item> current) {
            this.current = current;
        }

        @Override
        public boolean hasNext() {
            return this.current != null;
        }

        @Override
        public Item next() {
            Item item = this.current.getItem();
            this.current = this.current.getLink();
            return item;
        }

        @Override
        public void remove() {

        }
    }
}
