package com.company.packageMain;

import com.company.dataStructures_arrays.RandomisedQueues;

import java.util.Random;

public class RandomMain {
    public static void main(String[] args) {
        RandomisedQueues<Integer> randQ= new RandomisedQueues<>();
        System.out.println("Size of Random Queue: " + randQ.size());
        randQ.enqueue(10);
        randQ.enqueue(20);
        randQ.enqueue(30);
        randQ.enqueue(40);
        randQ.enqueue(50);
        randQ.enqueue(60);
        randQ.enqueue(70);
        randQ.enqueue(80);
        System.out.println("Size of Random Queue: " + randQ.size());

        System.out.println("All Items: ");
        for(int item: randQ){
            System.out.print(item + "\t");
        }
        System.out.println();
        System.out.println("Sample Item: "+randQ.sample());

        System.out.println("DQueue: " + randQ.deQueue());
        System.out.println("DQueue: " + randQ.deQueue());
        System.out.println("DQueue: " + randQ.deQueue());
        System.out.println("DQueue: " + randQ.deQueue());
        System.out.println("DQueue: " + randQ.deQueue());
        System.out.println("DQueue: " + randQ.deQueue());
        System.out.println("DQueue: " + randQ.deQueue());
        System.out.println("DQueue: " + randQ.deQueue());

        System.out.println("Size of Random Queue: " + randQ.size());
    }
}
