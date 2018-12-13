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

    public boolean insertItemAtPos(int item, int pos) {
        boolean isInserted = true;
        try {
            if (pos == 1) {
                Node newNode = new Node();
                newNode.setItem(item);

                Node temp = this.head;
                newNode.setLink(temp);
                this.head = newNode;

            } else if (this.getSize() >= pos) {
                Node newNode = new Node();
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

    public DeletedModel deleteItemAtEnd() {
        DeletedModel deletedModel = new DeletedModel();
        deletedModel.setIsDeleted(false);
        try {
            if (!this.isEmptyList()) {
                Node temp = this.head;
                while (temp.getLink().getLink() != null) {
                    temp = temp.getLink();
                }

                deletedModel.setDeletedItem(temp.getLink().getItem());
                temp.setLink(null);
            }
            deletedModel.setIsDeleted(true);

        } catch (Exception ex) {

        }

        return deletedModel;
    }

    public DeletedModel deleteItemAtStart() {
        DeletedModel deletedModel = new DeletedModel();
        deletedModel.setIsDeleted(false);
        try {
            if (!this.isEmptyList()) {
                Node temp = this.head;
                deletedModel.setDeletedItem(temp.getItem());
                temp = temp.getLink();
                this.head = temp;
                deletedModel.setIsDeleted(true);
            }

        } catch (Exception ex) {

        }

        return deletedModel;
    }

    public DeletedModel deleteItemAtPos(int pos) {
        DeletedModel deletedModel = new DeletedModel();
        deletedModel.setIsDeleted(true);
        try {
            if (pos == 1) {
                deletedModel.setDeletedItem(this.deleteItemAtStart()
                        .getDeletedItem());

            } else if (this.getSize() >= pos) {
                Node temp = this.head;

                for (int index = 1; index < (pos - 2); index++) {
                    temp = temp.getLink();
                }
                deletedModel.setDeletedItem(temp.getLink().getItem());
                temp.setLink(temp.getLink().getLink());
            } else {
                deletedModel.setIsDeleted(false);
            }
        } catch (Exception ex) {

        }

        return deletedModel;
    }

    public void printList() {
        Node temp = this.head;
        if (this.isEmptyList()) {
            System.out.println("List is Empty");
        } else {
            int i = 1;
            while (temp != null) {
                System.out.format("Data[%d]: %d \n", (i++), temp.getItem());
                temp = temp.getLink();
            }
        }
    }

    public int getSize() {
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
