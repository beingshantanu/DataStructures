package com.company.packageMain;

import com.company.operations.Operation;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
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
}
