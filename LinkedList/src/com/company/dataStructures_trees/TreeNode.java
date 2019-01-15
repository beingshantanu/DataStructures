package com.company.dataStructures_trees;

public class TreeNode<Key, Val> {
    private Key key;
    private Val value;
    private TreeNode left;
    private TreeNode right;

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public Val getValue() {
        return value;
    }

    public void setValue(Val value) {
        this.value = value;
    }

    public TreeNode<Key, Val> getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode<Key, Val> getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
