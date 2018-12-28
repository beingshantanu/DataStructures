package com.company.dataStructures_linkedLists;

import java.util.Iterator;

public class StackMaster<Item> implements Iterable<Item> {

    private Node<Item> top;

    public void push(Item item) {
        boolean isPushed = false;
        if (this.top == null) {
            this.top = new Node();
            this.top.setItem(item);
            this.top.setNext(null);
        } else {
            Node<Item> current = new Node<Item>();
            current.setItem(item);
            current.setNext(top);
            top = current;
        }
    }

    public Item pop() {
        Item item = top.getItem();
        top = top.getNext();
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new StackMasterIterator<Item>(this.top);
    }

    private class StackMasterIterator<Item> implements Iterator<Item> {

        private Node<Item> current;

        public StackMasterIterator(Node<Item> top) {
            this.current = top;
        }

        @Override
        public boolean hasNext() {
            return this.current != null;
        }

        @Override
        public Item next() {
            Item item = this.current.getItem();
            this.current = this.current.getNext();
            return item;
        }

        @Override
        public void remove() {

        }
    }
}
