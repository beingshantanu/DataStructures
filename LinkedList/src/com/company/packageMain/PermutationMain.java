package com.company.packageMain;

import com.company.dataStructures_arrays.RandomisedQueues;

public class PermutationMain {
    public static void main(String[] args) {
        RandomisedQueues<String> rQ = new RandomisedQueues<>();
        rQ.enqueue("A");
        rQ.enqueue("B");
        rQ.enqueue("C");
        rQ.enqueue("D");
        rQ.enqueue("E");
        rQ.enqueue("F");
        rQ.enqueue("G");
        rQ.enqueue("H");
        rQ.enqueue("I");

        int i = 0;
        while (i < 9) {
            System.out.println(rQ.deQueue());
            ++i;
        }

    }
}
