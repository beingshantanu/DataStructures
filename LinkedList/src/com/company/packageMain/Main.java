package com.company.packageMain;

import com.company.dataStructures_linkedLists.LinkedListMaster;
import com.company.operations.Operation;
import java.util.Scanner;

public class Main {
    static void callOp(){
        System.out.println("---> Menu <---");
        System.out.println("1. Linked List Operations");
        System.out.println("2. Stack Operations");
        System.out.println("3. Queue Operations");
        System.out.println("4. End");

        Scanner scan = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Enter Choice: ");
            choice = scan.nextInt();
            switch (choice) {
                case 1: {
                    new Operation().linkedListOperations();
                    break;
                }
                case 2: {
                    new Operation().stackOperations();
                    break;
                }
                case 3: {
                    new Operation().queueOperations();
                    break;
                }
            }

        } while (choice != 4);
        System.out.println("Program Ended");
    }

    public static void main(String[] args) {
        // callOp();

        LinkedListMaster<Integer> lm = new LinkedListMaster<>();
        lm.insertItemAtEnd(3);

        lm.insertItemAtEnd(2);
        lm.insertItemAtEnd(1);
        lm.insertItemAtEnd(4);
        lm.insertItemAtEnd(5);
        lm.insertItemAtEnd(15);
        lm.insertItemAtEnd(16);

        System.out.println(lm.getNodeFromTail(lm.getHead(), 4));
    }
}
