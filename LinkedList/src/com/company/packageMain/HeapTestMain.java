package com.company.packageMain;

import com.company.dataStructures_arrays.HeapDS;

import java.util.Iterator;
import java.util.Scanner;

public class HeapTestMain {
    public static void main(String[] args) {
        HeapDS<Integer> heapDs = new HeapDS<>(10);
        System.out.println("---> Menu <---");
        System.out.println("1. Add");
        System.out.println("2. Delete");
        System.out.println("3. End");

        Scanner scan = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Enter Choice: ");
            choice = scan.nextInt();
            switch (choice) {
                case 1: {
                    System.out.println("Enter Integer to insert: ");
                    heapDs.addToHeap(scan.nextInt());
                    System.out.println("Elements in the heap");
                    Iterator<Integer> it = heapDs.iterator();
                    while(it.hasNext()){
                        System.out.print(it.next() + "\t");
                    }
                    System.out.println();
                    System.out.println("Current HeapSize: "+ heapDs.getHeap_size());
                    break;
                }
                case 2: {
                    heapDs.addToHeap(21);
                    heapDs.addToHeap(14);
                    heapDs.addToHeap(6);
                    heapDs.addToHeap(2);
                    heapDs.addToHeap(10);
                    heapDs.addToHeap(1);
                    heapDs.addToHeap(5);

                    System.out.println("Deleted Element: " +
                            heapDs.deleteFromHeap());
                    Iterator<Integer> it = heapDs.iterator();
                    while(it.hasNext()){
                        System.out.print(it.next() + "\t");
                    }
                    System.out.println();
                    System.out.println("Current HeapSize: "+
                            heapDs.getHeap_size());
                    break;
                }
            }

        } while (choice != 3);
        System.out.println("Program Ended");

    }
}
