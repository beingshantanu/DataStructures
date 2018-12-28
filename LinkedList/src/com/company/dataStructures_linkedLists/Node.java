package com.company.dataStructures_linkedLists;

public class Node<Item> {
    private Item item;
    private Node<Item> next;

    public Node() {
        this.next = null;
    }

    public Item getItem() {
        return item;
    }

    public Node getNext() {
        return next;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public void setNext(Node<Item> next) {
        this.next = next;
    }
}
