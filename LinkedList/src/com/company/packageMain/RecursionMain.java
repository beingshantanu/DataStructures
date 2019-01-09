package com.company.packageMain;

public class RecursionMain {
    static int l = 0;
    static int multiplier = 10;
    static int max = 0;

    static int fact(int n) {
        if (n == 1)
            return 1;
        else
            return n * fact(n - 1);
    }

    static int numRev(int n) {
        if (n < 10) {
            return n;
        } else {
            int d = numRev(n / 10);
            int r = n % 10;
            l = r * multiplier + d;
            multiplier *= 10;
            return l;
        }
    }

    static void printArr(int[] a, int i) {
        if (i < a.length) {
            System.out.println(a[i]);
            printArr(a, ++i);
        }
    }

    static void findMax(int[] a, int i) {
        if (i < a.length) {
            if (a[i] >= max) {
                max = a[i];
            }
            findMax(a, ++i);
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 4, 5, 56, 7, 45};
//        printArr(a, 0);
        max = a[0];
        findMax(a, 0);
        System.out.println(max);
    }
}
