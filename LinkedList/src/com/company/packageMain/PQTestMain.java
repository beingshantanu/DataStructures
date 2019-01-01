package com.company.packageMain;


import com.company.dataStructures_arrays.HeapDS;
import com.company.dataStructures_arrays.PriorityQueue;
import com.company.dataStructures_arrays.PriorityQueueDS;

import java.util.Iterator;
import java.util.Scanner;

public class PQTestMain {
    public static void main(String[] args) {
        PriorityQueueDS<Integer> pq = new PriorityQueueDS<>(10);
        // pq.addToQueue(10, 1);

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
                    pq.addToQueue(10, 2);
                    pq.addToQueue(2, 3);
                    pq.addToQueue(3, 4);
                    pq.addToQueue(1, 1);
                    pq.addToQueue(7, 10);
                    pq.addToQueue(17, 3);
                    System.out.println("Elements in the Priority Queue");
                    Iterator<PriorityQueue> it = pq.iterator();
                    while (it.hasNext()) {
                        PriorityQueue item = it.next();
                        String toPrint = "Key: " + item.getKey() +
                                " \t Priority: " + item.getPriority();
                        System.out.print(toPrint);
                        System.out.println();
                    }
                    System.out.println();
                    System.out.println("Current PQ Size: " + pq.getSize());
                    break;
                }
                case 2: {

                    System.out.println("Deleted Element>> ");
                    PriorityQueue pqItem  = pq.deleteFromQueue();
                    System.out.println("Key: " +
                            pqItem.getKey() + "Priority: " +
                            pqItem.getPriority());
                    System.out.println("Elements in the Priority Queue");
                    Iterator<PriorityQueue> it = pq.iterator();
                    while (it.hasNext()) {
                        PriorityQueue item = it.next();
                        String toPrint = "Key: " + item.getKey() +
                                " \t Priority: " + item.getPriority();
                        System.out.print(toPrint);
                        System.out.println();
                    }
                    System.out.println();
                    System.out.println("Current PQ Size: " + pq.getSize());
                    break;
                }
            }

        } while (choice != 3);
        System.out.println("Program Ended");
    }
}
