package com.company.util;

public class Utility {
    public static void swap(Comparable a[], int i, int j) {
        Comparable temp = a[j];
        a[j] = a[i];
        a[i] = temp;
    }

    public static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) <= 0;
    }

    public static boolean great(Comparable a, Comparable b) {
        return a.compareTo(b) >= 0;
    }
}
