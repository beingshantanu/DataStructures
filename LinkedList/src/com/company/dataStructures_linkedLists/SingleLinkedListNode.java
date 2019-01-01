package com.company.dataStructures_linkedLists;

public class SingleLinkedListNode<Item> {
    private Item item;
    private SingleLinkedListNode<Item> next;

    public SingleLinkedListNode() {
        this.next = null;
    }

    public Item getItem() {
        return item;
    }

    public SingleLinkedListNode<Item> getNext() {
        return next;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public void setNext(SingleLinkedListNode<Item> next) {
        this.next = next;
    }
}
