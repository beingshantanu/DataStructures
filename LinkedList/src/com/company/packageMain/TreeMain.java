package com.company.packageMain;

import com.company.CustomException.BlankException;
import com.company.dataStructures_trees.TreeMaster;
import com.company.dataStructures_trees.TreeNode;

import java.util.Iterator;
import java.util.Map;

public class TreeMain {
    public static void main(String[] args) {
        TreeMaster<Integer, String> tree = new TreeMaster<>();
        tree.addNode(tree.getHead(), 12, "A");
        tree.addNode(tree.getHead(), 3, "B");
        tree.addNode(tree.getHead(), 16, "C");
        tree.addNode(tree.getHead(), 1, "D");
        tree.addNode(tree.getHead(), 8, "E");
        tree.addNode(tree.getHead(), 14, "F");
        tree.addNode(tree.getHead(), 20, "G");
        tree.addNode(tree.getHead(), 13, "H");
        tree.addNode(tree.getHead(), 15, "I");
        tree.addNode(tree.getHead(), 20, "I");
        tree.addNode(tree.getHead(), 17, "I");
        tree.addNode(tree.getHead(), 25, "I");
        System.out.println("Size of the BST: " + tree.getSize(tree.getHead()));
        System.out.println("Here is the keys of the List: ");
        Iterator<Integer> it = tree.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + "\t");
        }
        System.out.println("");
        try {
//            System.out.println("Min Element of the tree: " +
//                    tree.findMin(tree.getHead()).getKey());
//            System.out.println("Min Element of the right sub tree: " +
//                    tree.findMin(tree.getHead().getRight()).getKey());
            int key_to_search = 12;
            System.out.println("Key: " + key_to_search + " Value: " +
                    tree.get(tree.getHead(), key_to_search));

//            tree.deleteNode(tree.getHead(), 1);
//            System.out.println("Size of the BST: " + tree.getSize(tree.getHead()));
//            System.out.println("Here is the keys of the List: ");
//            it = tree.iterator();
//            while (it.hasNext()) {
//                System.out.print(it.next() + "\t");
//            }
//
//            System.out.println("");
//            tree.deleteNode(tree.getHead(), 3);
//            System.out.println("Size of the BST: " + tree.getSize(tree.getHead()));
//            System.out.println("Here is the keys of the List: ");
//            it = tree.iterator();
//            while (it.hasNext()) {
//                System.out.print(it.next() + "\t");
//            }

            System.out.println("");
            tree.deleteNode(tree.getHead(), 16);
            System.out.println("Size of the BST: " + tree.getSize(tree.getHead()));
            System.out.println("Here is the keys of the List: ");
            it = tree.iterator();
            while (it.hasNext()) {
                System.out.print(it.next() + "\t");
            }
        } catch (BlankException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
