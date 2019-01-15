package com.company.packageMain;

import com.company.CustomException.BlankException;
import com.company.dataStructures_trees.TreeMaster;

import java.util.Iterator;

public class TreeMain {
    public static void main(String[] args) {
        TreeMaster<Integer, String> tree = new TreeMaster<>();
        tree.addNode(tree.getHead(), 12, "A");
        tree.addNode(tree.getHead(), 3, "B");
        tree.addNode(tree.getHead(), 16, "C");
        tree.addNode(tree.getHead(), 1, "D");
        tree.addNode(tree.getHead(), 8, "E");
        tree.addNode(tree.getHead(), 5, "F");
        tree.addNode(tree.getHead(), 10, "G");

        System.out.println("Size of the BST: " + tree.getSize(tree.getHead()));
        System.out.println("Here is the keys of the List: ");
        Iterator<Integer> it = tree.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + "\t");
        }
        System.out.println("");
        try {
            int key_to_search = 12;
            System.out.println("Key: " + key_to_search + " Value: " +
                    tree.get(tree.getHead(), key_to_search));

            tree.deleteNode(tree.getHead(),1);
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
