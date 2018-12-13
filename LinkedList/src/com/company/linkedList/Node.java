package com.company.linkedList;

public class Node {
    private int item;
    private Node link;

    public Node() {
        this.link = null;
    }

    public int getItem() {
        return item;
    }

    public Node getLink() {
        return link;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public void setLink(Node link) {
        this.link = link;
    }
}
