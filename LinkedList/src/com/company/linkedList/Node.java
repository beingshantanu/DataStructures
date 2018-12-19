package com.company.linkedList;

public class Node<Item> {
    private Item item;
    private Node<Item> link;

    public Node() {
        this.link = null;
    }

    public Item getItem() {
        return item;
    }

    public Node getLink() {
        return link;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public void setLink(Node<Item> link) {
        this.link = link;
    }
}
