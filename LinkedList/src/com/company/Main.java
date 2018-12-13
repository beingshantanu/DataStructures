package com.company;

import com.company.linkedList.LinkedListMaster;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("---> Menu <---");
        System.out.println("1. Insert at the Start");
        System.out.println("2. Insert at the End");
        System.out.println("3. Insert at the Specific Position");
        System.out.println("4. Delete at the Start");
        System.out.println("5. Delete at the End");
        System.out.println("6. Delete at the Specific Position");
        System.out.println("7. Print LinkedList");
        System.out.println("8. End");

        LinkedListMaster linkedList = new LinkedListMaster();
        Scanner scan = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Enter Choice: ");
            choice = scan.nextInt();
            switch (choice){
                case 1:{
                    System.out.println("Enter Item to Insert at the Start:");
                    int item = scan.nextInt();
                    boolean isInserted = linkedList.insertItemAtStart(item);
                    if(isInserted) {
                        System.out.println("Item inserted at the start: " + item);
                    }
                    System.out.println("Current List Items:");
                    linkedList.printList();
                    break;
                }
                case 2:{
                    System.out.println("Enter Item to Insert at the End:");
                    int item = scan.nextInt();
                    boolean isInserted = linkedList.insertItemAtEnd(item);
                    if(isInserted) {
                        System.out.println("Item inserted at the End: " + item);
                    }
                    System.out.println("Current List Items:");
                    linkedList.printList();
                    break;
                }
                case 7:{
                    System.out.println("All Items:");
                    linkedList.printList();
                    break;
                }
            }

        } while (choice != 8);
        System.out.println("Program Ended");
    }
}