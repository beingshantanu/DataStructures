package com.company.packageMain;

import com.company.sort.Sort;

public class SortMain {

    public static void mergeSortDemo(int []arr) {
        int low = 0;
        int high = arr.length - 1;
        new Sort().mergeSort(arr, low, high);
        System.out.println("Merge Sort Demo: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }

    public static void quickSortDemo(int []arr){
        int low = 0;
        int high = arr.length - 1;
        new Sort().quickSort(arr, low, high);
        System.out.println("Quick Sort Demo: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }

    public static void selectionSortDemo(Comparable []arr){
        new Sort().selectionSort(arr);
        System.out.println("Selection Sort Demo: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }

    public static void main(String[] args) {
        // Integer[] arr = {1, 3, 5, 7, 1, 4, 6};
        Integer[] arr = {1,8,9,2,5,7};
        // Integer []arr = {12, 11, 13, 5, 6, 7};
        // Integer []arr = {10, 7, 8, 6, 1, 9};

        // mergeSortDemo(arr);
        // quickSortDemo(arr);
        selectionSortDemo(arr);
    }
}
