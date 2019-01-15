package com.company.dataStructures_trees;

import com.company.CustomException.BlankException;

import java.security.KeyPair;
import java.util.*;

public class TreeMaster<Key extends Comparable<Key>, Val>
        implements Iterable<Key> {
    private TreeNode head;
    private Key minKey;

    public Key getMinKey() {
        return minKey;
    }

    public TreeNode getHead() {
        return head;
    }

    public void addNode(TreeNode<Key, Val> head, Key key, Val val) {
        this.head = this.put(head, key, val);
    }

    public int getSize(TreeNode<Key, Val> head) {
        if (head == null) {
            return 0;
        }
        return 1 + getSize(head.getLeft()) + getSize(head.getRight());
    }

    public Val get(TreeNode<Key, Val> head, Key key) throws BlankException {
        return this.searchTree(head, key).getValue();
    }

    public void deleteNode(TreeNode<Key, Val> head, Key key)
            throws BlankException {
        this.head = this.delete(head, key);
    }

    private TreeNode<Key, Val> delete(TreeNode<Key, Val> head, Key key)
            throws BlankException {
        int comparable = key.compareTo(head.getKey());
        if (comparable > 0) {
            head.setRight(delete(head.getRight(), key));
        } else if (comparable < 0) {
            head.setLeft(delete(head.getLeft(), key));
        } else if (comparable == 0) {
            if (head.getLeft() == null && head.getRight() == null) {
                head = null;
            } else if (head.getLeft() != null && head.getRight() != null) {
                TreeNode<Key, Val> right_min = findMinItr(head.getRight());
                head.setKey(right_min.getKey());
                delete(head.getRight(),right_min.getKey());
            } else if (head.getLeft() != null || head.getRight() != null) {
                head = (head.getLeft() != null) ? head.getLeft() : head.getRight();
            }
        }
        return head;
    }

    private TreeNode<Key, Val> findMin(TreeNode<Key, Val> head)
            throws BlankException {
        if (head == null) {
            throw new BlankException("Key is not present in the tree");
        } else if(head.getLeft()==null){
            return head;
        }
        return findMin(head.getLeft());
    }

    private TreeNode<Key, Val> findMinItr(TreeNode<Key, Val> head)
            throws BlankException {
        if (head == null) {
            throw new BlankException("Key is not present in the tree");
        }
        TreeNode<Key, Val> min_node = head;
        TreeNode<Key, Val> temp = head;
        while(temp.getLeft()!=null){
            temp = temp.getLeft();
        }

        return temp;
    }

    private TreeNode<Key, Val> put(TreeNode<Key, Val> head, Key key, Val val) {
        if (head == null) {
            head = new TreeNode<>();
            head.setKey(key);
            head.setValue(val);
            head.setLeft(null);
            head.setRight(null);
            return head;
        }
        int comparable = key.compareTo(head.getKey());
        if (comparable > 0) {
            head.setRight(put(head.getRight(), key, val));
        } else if (comparable < 0) {
            head.setLeft(put(head.getLeft(), key, val));
        } else if (comparable == 0) {
            head.setValue(val);
        }
        return head;
    }

    private TreeNode<Key, Val> searchTree(TreeNode<Key, Val> head, Key key)
            throws BlankException {
        if (head == null) {
            throw new BlankException("Key is not present in the tree");
        }

        TreeNode<Key, Val> node = null;
        int comparable = key.compareTo(head.getKey());
        if (comparable == 0) {
            node = head;
        } else if (comparable < 0) {
            node = searchTree(head.getLeft(), key);
        } else if (comparable > 0) {
            node = searchTree(head.getRight(), key);
        }

        return node;
    }

    @Override
    public Iterator<Key> iterator() {
        return new TreeIterator(this.getSize(this.getHead()), this.getHead());
    }

    private class TreeIterator implements Iterator<Key> {
        private int size;
        // private Key[] arr;
        private List<Key> treeList;
        private int index = 0;

        public TreeIterator(int size, TreeNode<Key, Val> head) {
            this.size = size;
            treeList = new ArrayList();
            // this.arr = (Key[]) new Object[this.size];
            this.inOrderTraversal(head);
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return this.index < this.size;
        }

        @Override
        public Key next() {
            return treeList.get(index++);
        }

        @Override
        public void remove() {

        }

        private void inOrderTraversal(TreeNode<Key, Val> head) {
            if (head == null) {
                return;
            }
            inOrderTraversal(head.getLeft());
            treeList.add(head.getKey());
            inOrderTraversal(head.getRight());
        }
    }
}
