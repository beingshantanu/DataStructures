package com.company.packageMain;

import com.company.dataStructures_linkedLists.DeQueueMaster;

import java.util.Iterator;

public class DeQueueMain {
    public static void main(String[] args) {
        DeQueueMaster<Integer> deQueueMaster = new DeQueueMaster<Integer>();
        System.out.println("Initial size of DeQueue: " + deQueueMaster.size());
        Iterator<Integer> it = null;

        System.out.println("12 is added at first.");
        deQueueMaster.addFirst(12);
        System.out.println("Size of DeQueue: "
                + deQueueMaster.size());

        System.out.println("Current items after adding 12 >>");
        it = deQueueMaster.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

        //--------------
        System.out.println("15 is added at first.");
        deQueueMaster.addFirst(15);
        System.out.println("Size of DeQueue: "
                + deQueueMaster.size());

        System.out.println("Current items after adding 15 >>");
        it = deQueueMaster.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

        //--------------
        System.out.println("25 is added at last.");
        deQueueMaster.addLast(25);
        System.out.println("Size of DeQueue: "
                + deQueueMaster.size());

        System.out.println("Current items after adding 25 >>");
        it = deQueueMaster.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

        //--------------
        System.out.println("35 is added at Last.");
        deQueueMaster.addLast(35);
        System.out.println("Size of DeQueue: "
                + deQueueMaster.size());

        System.out.println("Current items after adding 35 >>");
        it = deQueueMaster.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

        // Delete First
        //----------
        System.out.println("Element deleted: " + deQueueMaster.removeFirst());
        System.out.println("Size of DeQueue: "
                + deQueueMaster.size());
        it = deQueueMaster.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

        //----------
        System.out.println("Element deleted: " + deQueueMaster.removeFirst());
        System.out.println("Size of DeQueue: "
                + deQueueMaster.size());
        it = deQueueMaster.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

        //----------
        System.out.println("Element deleted: " + deQueueMaster.removeFirst());
        System.out.println("Size of DeQueue: "
                + deQueueMaster.size());
        it = deQueueMaster.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

        //----------
        System.out.println("Element deleted: " + deQueueMaster.removeFirst());
        System.out.println("Size of DeQueue: "
                + deQueueMaster.size());
        it = deQueueMaster.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }


        // Add item
        System.out.println("12 is added at first.");
        deQueueMaster.addFirst(12);
        System.out.println("Size of DeQueue: "
                + deQueueMaster.size());

        System.out.println("Current items after adding 12 >>");
        it = deQueueMaster.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

        //--------------
        System.out.println("15 is added at first.");
        deQueueMaster.addFirst(15);
        System.out.println("Size of DeQueue: "
                + deQueueMaster.size());

        System.out.println("Current items after adding 15 >>");
        it = deQueueMaster.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

        // Delete Last
        //----------
        System.out.println("Element deleted: " + deQueueMaster.removeLast());
        System.out.println("Size of DeQueue: "
                + deQueueMaster.size());
        it = deQueueMaster.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

        //----------
        System.out.println("Element deleted: " + deQueueMaster.removeLast());
        System.out.println("Size of DeQueue: "
                + deQueueMaster.size());
        it = deQueueMaster.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

    }
}
