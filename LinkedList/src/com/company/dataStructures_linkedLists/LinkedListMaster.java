package com.company.dataStructures_linkedLists;


import java.util.Iterator;

public class LinkedListMaster<Item extends Comparable<Item>> implements Iterable<Item> {
    private SingleLinkedListNode<Item> head;

    public LinkedListMaster() {
        this.head = null;
    }

    public SingleLinkedListNode<Item> getHead() {
        return this.head;
    }

    public boolean insertItemAtStart(Item item) {
        boolean isInserted = false;
        try {
            if (!this.isEmptyList()) {
                SingleLinkedListNode<Item> node = new SingleLinkedListNode<>();
                node.setItem(item);
                node.setNext(this.head);
                this.head = node;
            } else {
                this.head = new SingleLinkedListNode();
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
                SingleLinkedListNode<Item> temp = this.head;
                while (temp.getNext() != null) {
                    temp = temp.getNext();
                }

                temp.setNext(new SingleLinkedListNode());
                temp.getNext().setItem(item);

            } else {
                this.head = new SingleLinkedListNode<>();
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
                SingleLinkedListNode<Item> newNode = new SingleLinkedListNode<>();
                newNode.setItem(item);

                SingleLinkedListNode temp = this.head;
                newNode.setNext(temp);
                this.head = newNode;

            } else if (this.getSize() >= pos) {
                SingleLinkedListNode<Item> newNode = new SingleLinkedListNode<>();
                newNode.setItem(item);
                SingleLinkedListNode temp = this.head;

                for (int index = 1; index < (pos - 1); index++) {
                    temp = temp.getNext();
                }
                newNode.setNext(temp.getNext());
                temp.setNext(newNode);

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
                SingleLinkedListNode<Item> temp = this.head;
                while (temp.getNext().getNext() != null) {
                    temp = temp.getNext();
                }

                deletedModel.setDeletedItem((Item) temp.getNext().getItem());
                temp.setNext(null);
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
                SingleLinkedListNode<Item> temp = this.head;
                deletedModel.setDeletedItem(temp.getItem());
                temp = temp.getNext();
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
                SingleLinkedListNode<Item> temp = this.head;

                for (int index = 1; index < (pos - 2); index++) {
                    temp = temp.getNext();
                }
                deletedModel.setDeletedItem((Item) temp.getNext().getItem());
                temp.setNext(temp.getNext().getNext());
            } else {
                deletedModel.setIsDeleted(false);
            }
        } catch (Exception ex) {

        }

        return deletedModel;
    }

    public void printList() {
        SingleLinkedListNode<Item> temp = this.head;
        if (this.isEmptyList()) {
            System.out.println("List is Empty");
        } else {
            int i = 1;
            while (temp != null) {
                System.out.println("Data[" + (i++) + "]:" + temp.getItem());
                temp = temp.getNext();
            }
        }
    }

    public void reverseLinkList() {
        SingleLinkedListNode<Item> cur = this.head;
        SingleLinkedListNode<Item> prev;
        SingleLinkedListNode<Item> nxt = cur.getNext();
        do {
            prev = cur;
            cur = nxt;
            nxt = cur.getNext();
            cur.setNext(prev);

        } while (nxt != null);

        this.head.setNext(null);
        this.head = cur;
    }

    public int getSize() {
        int size = 0;
        SingleLinkedListNode<Item> temp = this.head;

        while (temp != null) {
            ++size;
            temp = temp.getNext();
        }

        return size;
    }

    public SingleLinkedListNode<Item> appendList(SingleLinkedListNode<Item> head1,
                                                 SingleLinkedListNode<Item> head2) {
        SingleLinkedListNode<Item> cur = head1;
        while (cur.getNext() != null) {
            cur = cur.getNext();
        }
        cur.setNext(head2);
        return head1;
    }

    public Item findMergePoint(SingleLinkedListNode<Item> head1,
                               SingleLinkedListNode<Item> head2) {
        Item item = null;
        SingleLinkedListNode<Item> cur1 = head1;
        SingleLinkedListNode<Item> cur2 = head2;

        while (cur1 != null) {
             item = cur1.getItem();
            while (cur2 != null) {
                if (cur2.getItem().compareTo(cur1.getItem()) == 0) {
                    while (cur2 != null) {
                        cur2 = cur2.getNext();
                        cur1 = cur1.getNext();
                        if (cur1.getItem().compareTo(cur2.getItem()) != 0) {
                            break;
                        }
                    }
                }

                if (cur2 == null) {
                    break;
                }
                cur2 = cur2.getNext();
            }
            if (cur1 == null) {
                break;
            }
            cur1 = cur1.getNext();
            cur2 = head2;
        }
        return item;
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

        private SingleLinkedListNode<Item> current;

        public LinkedListMasterIterator(SingleLinkedListNode<Item> head) {
            this.current = head;
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
