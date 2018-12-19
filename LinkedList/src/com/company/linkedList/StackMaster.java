package com.company.linkedList;

import java.util.Iterator;

public class StackMaster<Item> implements Iterable<Item> {

    private Node<Item> top;

    public void push(Item item) {
        boolean isPushed = false;
        if (this.top == null) {
            this.top = new Node();
            this.top.setItem(item);
            this.top.setLink(null);
        } else {
            Node<Item> current = new Node<Item>();
            current.setItem(item);
            current.setLink(top);
            top = current;
        }
    }

    public Item pop() {
        Item item = top.getItem();
        top = top.getLink();
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
            this.current = this.current.getLink();
            return item;
        }

        @Override
        public void remove() {

        }
    }
}
