package com.company.dataStructures_linkedLists;

import com.company.util.Utility;

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

            } else if (this.getSize(this.head) >= pos) {
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

            } else if (this.getSize(this.head) >= pos) {
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

    public int getSize(SingleLinkedListNode<Item> listHead) {
        int size = 0;
        SingleLinkedListNode<Item> temp = listHead;

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

    public SingleLinkedListNode<Item> findMergePoint(SingleLinkedListNode<Item> head1,
                                                     SingleLinkedListNode<Item> head2) {
        int size_of_first_list = this.getSize(head1);
        int size_of_second_list = this.getSize(head2);
        SingleLinkedListNode<Item> cur_first = head1, cur_second = head2;

        int diff_size = (size_of_first_list - size_of_second_list);
        if (diff_size >= 0) {
            while ((diff_size--) > 0) {
                cur_first = cur_first.getNext();
            }
        } else {
            while ((diff_size++) > 0) {
                cur_second = cur_second.getNext();
            }
        }
        while (cur_first != null) {
            if (cur_first == cur_second) {
                break;
            }
            cur_first = cur_first.getNext();
            cur_second = cur_second.getNext();
        }

        return cur_first;
    }

    public SingleLinkedListNode<Item> mergeSortedLists(
            SingleLinkedListNode<Item> head1,
            SingleLinkedListNode<Item> head2) {
        if (head1 == null || head2 == null) {
            throw new IllegalArgumentException("Input Lists can not be empty.");
        }

        SingleLinkedListNode<Item> res = null;
        SingleLinkedListNode<Item> cur = null;
        if (Utility.less(head1.getItem(), head2.getItem())) {
            res = head1;
            head1 = head1.getNext();
        } else {
            res = head2;
            head2 = head2.getNext();
        }
        cur = res;
        while (true) {
            if (head1 == null || head2 == null) {
                break;
            }
            if (Utility.less(head1.getItem(), head2.getItem())) {
                cur.setNext(head1);
                head1 = head1.getNext();
            } else {
                cur.setNext(head2);
                head2 = head2.getNext();
            }
            cur = cur.getNext();
        }

        if (head2 == null) {
            cur.setNext(head1);
        } else if (head1 == null) {
            cur.setNext(head2);
        }
        this.head = res;
        return res;
    }

    public boolean isLoopPresent(SingleLinkedListNode<Item> lHead) {
        if (lHead == null) {
            throw new IllegalArgumentException("List is Empty");
        }
        SingleLinkedListNode<Item> slow = lHead;
        SingleLinkedListNode<Item> fast = lHead.getNext();
        boolean isPresent = false;
        while (true) {
            if (fast == slow) {
                isPresent = true;
                break;
            }
            if (fast == null) {
                break;
            }
            if (fast.getNext() == null) {
                break;
            }
            if (slow == null) {
                break;
            }
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return isPresent;
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
