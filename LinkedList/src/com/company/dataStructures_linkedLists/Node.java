package com.company.dataStructures_linkedLists;

public class Node<Item> {
    private Item item;
    private Node<Item> next;
    private Node<Item> prev;


    public Node() {
        this.next = null;
    }

    public Item getItem() {
        return item;
    }

    public Node<Item> getNext() {
        return next;
    }

    public Node<Item> getPrev() {
        return prev;
    }

    public void setPrev(Node<Item> prev) {
        this.prev = prev;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public void setNext(Node<Item> next) {
        this.next = next;
    }
}
