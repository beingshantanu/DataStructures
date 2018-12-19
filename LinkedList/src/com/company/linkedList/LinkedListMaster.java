package com.company.linkedList;


import java.util.Iterator;

public class LinkedListMaster<Item> implements Iterable<Item> {
    private Node<Item> head;

    public LinkedListMaster() {
        this.head = null;
    }

    public boolean insertItemAtStart(Item item) {
        boolean isInserted = false;
        try {
            if (!this.isEmptyList()) {
                Node<Item> node = new Node<>();
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

    public boolean insertItemAtEnd(Item item) {
        boolean isInserted = false;
        try {
            if (!this.isEmptyList()) {
                Node<Item> temp = this.head;
                while (temp.getLink() != null) {
                    temp = temp.getLink();
                }

                temp.setLink(new Node());
                temp.getLink().setItem(item);

            } else {
                this.head = new Node<>();
                this.head.setItem(item);
            }
            isInserted = true;

        } catch (Exception ex) {

        }

        return isInserted;
    }

    public boolean insertItemAtPos(Item item, int pos) {
        boolean isInserted = true;
        try {
            if (pos == 1) {
                Node<Item> newNode = new Node<>();
                newNode.setItem(item);

                Node temp = this.head;
                newNode.setLink(temp);
                this.head = newNode;

            } else if (this.getSize() >= pos) {
                Node<Item> newNode = new Node<>();
                newNode.setItem(item);
                Node temp = this.head;

                for (int index = 1; index < (pos - 1); index++) {
                    temp = temp.getLink();
                }
                newNode.setLink(temp.getLink());
                temp.setLink(newNode);

            } else {
                isInserted = false;
            }
        } catch (Exception ex) {

        }

        return isInserted;
    }

    public DeletedModel<Item> deleteItemAtEnd() {
        DeletedModel<Item> deletedModel = new DeletedModel<>();
        deletedModel.setIsDeleted(false);
        try {
            if (!this.isEmptyList()) {
                Node<Item> temp = this.head;
                while (temp.getLink().getLink() != null) {
                    temp = temp.getLink();
                }

                deletedModel.setDeletedItem((Item) temp.getLink().getItem());
                temp.setLink(null);
            }
            deletedModel.setIsDeleted(true);

        } catch (Exception ex) {

        }

        return deletedModel;
    }

    public DeletedModel<Item> deleteItemAtStart() {
        DeletedModel<Item> deletedModel = new DeletedModel<>();
        deletedModel.setIsDeleted(false);
        try {
            if (!this.isEmptyList()) {
                Node<Item> temp = this.head;
                deletedModel.setDeletedItem(temp.getItem());
                temp = temp.getLink();
                this.head = temp;
                deletedModel.setIsDeleted(true);
            }

        } catch (Exception ex) {

        }

        return deletedModel;
    }

    public DeletedModel<Item> deleteItemAtPos(int pos) {
        DeletedModel<Item> deletedModel = new DeletedModel<>();
        deletedModel.setIsDeleted(true);
        try {
            if (pos == 1) {
                deletedModel.setDeletedItem(this.deleteItemAtStart()
                        .getDeletedItem());

            } else if (this.getSize() >= pos) {
                Node<Item> temp = this.head;

                for (int index = 1; index < (pos - 2); index++) {
                    temp = temp.getLink();
                }
                deletedModel.setDeletedItem((Item) temp.getLink().getItem());
                temp.setLink(temp.getLink().getLink());
            } else {
                deletedModel.setIsDeleted(false);
            }
        } catch (Exception ex) {

        }

        return deletedModel;
    }

    public void printList() {
        Node<Item> temp = this.head;
        if (this.isEmptyList()) {
            System.out.println("List is Empty");
        } else {
            int i = 1;
            while (temp != null) {
                System.out.println("Data[" + (i++) + "]:" + temp.getItem());
                temp = temp.getLink();
            }
        }
    }

    public int getSize() {
        int size = 0;
        Node<Item> temp = this.head;

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

    @Override
    public Iterator<Item> iterator() {
        return new LinkedListMasterIterator(head);
    }

    private class LinkedListMasterIterator implements Iterator<Item> {

        private Node<Item> current;

        public LinkedListMasterIterator(Node<Item> head) {
            this.current = head;
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
