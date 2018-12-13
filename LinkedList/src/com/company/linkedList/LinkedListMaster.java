package com.company.linkedList;


public class LinkedListMaster {
    private Node head;

    public LinkedListMaster() {
        this.head = null;
    }

    public boolean insertItemAtStart(int item) {
        boolean isInserted = false;
        try {
            if (!this.isEmptyList()) {
                Node node = new Node();
                node.setItem(item);
                node.setLink(this.head);
                this.head = node;
            } else {
                this.head = new Node();
                this.head.setItem(item);
            }
            isInserted = true;

        } catch (Exception ex) {

        }

        return isInserted;
    }

    public boolean insertItemAtEnd(int item) {
        boolean isInserted = false;
        try {
            if (!this.isEmptyList()) {
                Node temp = this.head;
                while (temp.getLink() != null) {
                    temp = temp.getLink();
                }

                temp.setLink(new Node());
                temp.getLink().setItem(item);

            } else {
                this.head = new Node();
                this.head.setItem(item);
            }
            isInserted = true;
        } catch (Exception ex) {

        }

        return isInserted;
    }

    public void printList() {
        Node temp = this.head;
        if (this.isEmptyList()) {
            System.out.println("List is Empty");
        } else {
            int i = 0;
            while (temp != null) {
                System.out.format("Data[%d]: %d \n", (i++), temp.getItem());
                temp = temp.getLink();
            }
        }
    }

    private int getSize() {
        int size = 0;
        Node temp = this.head;

        while (temp != null) {
            ++size;
            temp = temp.getLink();
        }

        return size;
    }

    private boolean isEmptyList() {
        boolean isEmpty = false;
        if (this.head == null) {
            isEmpty = true;
        }

        return isEmpty;
    }

}
