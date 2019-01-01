package com.company.operations;

import com.company.dataStructures_linkedLists.*;

import java.util.Iterator;
import java.util.Scanner;

public class Operation {

    public void linkedListOperations() {
        System.out.println("---> Linked List Operations Menu <---");
        System.out.println("1. Insert at the Start");
        System.out.println("2. Insert at the End");
        System.out.println("3. Insert at the Specific Position");
        System.out.println("4. Delete at the Start");
        System.out.println("5. Delete at the End");
        System.out.println("6. Delete at the Specific Position");
        System.out.println("7. Print LinkedList");
        System.out.println("8. Reverse a Linked List");
        System.out.println("9. Find Merge Point");
        System.out.println("10. End");

        LinkedListMaster<Double> linkedList = new LinkedListMaster<>();
        Scanner scan = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Enter Choice: ");
            choice = scan.nextInt();
            switch (choice) {
                case 1: {
                    System.out.println("Enter Item to Insert at the Start:");
                    double item = scan.nextDouble();
                    boolean isInserted = linkedList.insertItemAtStart(item);
                    if (isInserted) {
                        System.out.println("Item inserted at the start: " + item);
                    }
                    System.out.println("Current List Items:");
                    linkedList.printList();
                    break;
                }
                case 2: {
                    System.out.println("Enter Item to Insert at the End:");
                    double item = scan.nextDouble();
                    boolean isInserted = linkedList.insertItemAtEnd(item);
                    if (isInserted) {
                        System.out.println("Item inserted at the End: " + item);
                    }
                    System.out.println("Current List Items:");
                    linkedList.printList();
                    break;
                }
                case 3: {
                    System.out.println("Enter Item to Insert:");
                    double item = scan.nextDouble();
                    System.out.println("Enter position to Insert:");
                    int pos = scan.nextInt();

                    boolean isInserted = linkedList.insertItemAtPos(item, pos);
                    if (isInserted) {
                        System.out.println("Item inserted: " + item);
                    } else {
                        System.out.println("The size of the Linked List: " +
                                linkedList.getSize());
                        System.out.println("Position is greater than size of the list");
                    }
                    System.out.println("Current List Items:");
                    linkedList.printList();
                    break;
                }
                case 4: {
                    DeletedModel delModel = linkedList.deleteItemAtStart();
                    if (delModel.getIsDeleted()) {
                        System.out.println("Item deleted from start: " +
                                delModel.getDeletedItem());
                    } else {
                        System.out.println("Deletion at the start can not be completed");
                    }
                    System.out.println("Current List Items:");
                    linkedList.printList();
                    break;
                }
                case 5: {
                    DeletedModel delModel = linkedList.deleteItemAtEnd();
                    if (delModel.getIsDeleted()) {
                        System.out.println("Item deleted at the end: " +
                                delModel.getDeletedItem());
                    } else {
                        System.out.println("Deletion at the start can not be completed");
                    }
                    System.out.println("Current List Items:");
                    linkedList.printList();
                    break;
                }
                case 6: {
                    System.out.println("Enter position to delete:");
                    int pos = scan.nextInt();
                    DeletedModel delModel = linkedList.deleteItemAtPos(pos);
                    if (delModel.getIsDeleted()) {
                        System.out.println("Item deleted: " +
                                delModel.getDeletedItem());
                    } else {
                        System.out.println("Deletion at the start can not be completed");
                    }
                    System.out.println("Current List Items:");
                    linkedList.printList();
                    break;
                }
                case 7: {
                    Iterator<Double> it = linkedList.iterator();
                    int i = 0;
                    System.out.println("All Elements in the List:");
                    while (it.hasNext()) {
                        System.out.println("Data[" + (i++) + "]:" + it.next());
                    }
                    break;
                }
                case 8:{
                    linkedList.reverseLinkList();
                    Iterator<Double> it = linkedList.iterator();
                    int i = 0;
                    System.out.println("All Elements in the List:");
                    while (it.hasNext()) {
                        System.out.println("Data[" + (i++) + "]:" + it.next());
                    }
                    break;
                }
                case 9:{
                    LinkedListMaster<Integer> ll1 = new LinkedListMaster<>();
                    ll1.insertItemAtEnd(1);
                    ll1.insertItemAtEnd(2);
                    ll1.insertItemAtEnd(17);
                    SingleLinkedListNode<Integer> head1 = ll1.getHead();

                    LinkedListMaster<Integer> llCommon = new LinkedListMaster<>();
                    llCommon.insertItemAtEnd(2);
                    llCommon.insertItemAtEnd(5);
                    llCommon.insertItemAtEnd(9);

                    SingleLinkedListNode<Integer> headCommon = llCommon.getHead();
                    LinkedListMaster<Integer> llFirst = new LinkedListMaster<>();
                    SingleLinkedListNode<Integer> headFirst =
                            llFirst.appendList(head1, headCommon);

                    LinkedListMaster<Integer> ll2 = new LinkedListMaster<>();
                    ll2.insertItemAtEnd(7);
                    ll2.insertItemAtEnd(2);
                    ll2.insertItemAtEnd(3);
                    SingleLinkedListNode<Integer> head2 = ll2.getHead();

                    LinkedListMaster<Integer> llSecond = new LinkedListMaster<>();
                    SingleLinkedListNode<Integer> headSecond =
                            llSecond.appendList(head2, headCommon);

                    LinkedListMaster<Integer> llMerge = new LinkedListMaster<>();

                    Integer i = llMerge.findMergePoint(head1, head2);
                    System.out.println("Merge point: "+ i.intValue());
                    break;
                }
            }

        } while (choice != 10);
        System.out.println("Linked List execution ended");
    }

    public void stackOperations() {
        System.out.println("---> Stack Operations Menu <---");
        System.out.println("1. Push");
        System.out.println("2. Pop");
        System.out.println("3. Print");
        System.out.println("4. End");
        StackMaster<Float> stack = new StackMaster<>();
        Scanner scan = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Enter Choice: ");
            choice = scan.nextInt();
            switch (choice) {
                case 1: {
                    System.out.println("Enter item to push:");
                    float item = scan.nextFloat();
                    stack.push(item);
                    break;
                }
                case 2: {
                    float item = stack.pop();
                    System.out.println("Item popped:" + item);
                    break;
                }
                case 3: {
                    Iterator<Float> it = stack.iterator();
                    int i = 0;
                    while (it.hasNext()) {
                        System.out.println("Data[" + (i++) + "]:" + it.next());
                    }
                    break;
                }
            }
        } while (choice != 4);

        System.out.println("Stack execution ended");
    }

    public void queueOperations() {
        System.out.println("---> Queue Operations Menu <---");
        System.out.println("1. Enqueue");
        System.out.println("2. Dequeue");
        System.out.println("3. Print");
        System.out.println("4. End");
        QueueMaster<Float> queue = new QueueMaster<>();
        Scanner scan = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Enter Choice: ");
            choice = scan.nextInt();
            switch (choice) {
                case 1: {
                    System.out.println("Enter item to Enqueue:");
                    float item = scan.nextFloat();
                    queue.enQueue(item);
                    break;
                }
                case 2: {
                    Float item = queue.deQueue();
                    System.out.println("Item popped:" + item);
                    break;
                }
                case 3: {
                    Iterator<Float> it = queue.iterator();
                    int i = 0;
                    while (it.hasNext()) {
                        System.out.println("Data[" + (i++) + "]:" + it.next());
                    }
                    break;
                }
            }
        } while (choice != 4);

        System.out.println("Queue execution ended");
    }

    public Double evaluateArithMaticExpression(String expr) {
        // ((1*2)+3)
        Double exprValue = null;
        if(expr.startsWith("(") && expr.endsWith(")")) {
            StackMaster<Character> operatorStack = new StackMaster<Character>();
            StackMaster<Double> operandStack = new StackMaster<Double>();
            char[] c = expr.toCharArray();
            for (int i = 0; i < c.length; i++) {
                if (c[i] == '(' || c[i] == ' ') {

                } else if (c[i] == '+' || c[i] == '*') {
                    operatorStack.push(c[i]);
                } else if (c[i] == ')') {
                    Double firstOperand = operandStack.pop();
                    Double secondOperand = operandStack.pop();
                    char operator = operatorStack.pop();
                    switch (operator) {
                        case '*': {
                            operandStack.push(firstOperand * secondOperand);
                            break;
                        }
                        case '+': {
                            operandStack.push(firstOperand + secondOperand);
                            break;
                        }
                    }
                } else if (c[i] >= '0' && c[i] <= '9') {
                    StringBuffer sb = new StringBuffer();
                    while (c[i] >= '0' && c[i] <= '9') {
                        sb.append(c[i]);
                        i++;
                    }
                    operandStack.push(Double.parseDouble(sb.toString()));
                    i--;

                }
            }
            exprValue = operandStack.pop();
        }
        return exprValue;
    }
}


