package com.company.sort;

import com.company.util.Utility;

import java.util.Comparator;

public class Sort {

    public void mergeSort(int a[], int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(a, low, mid);
            mergeSort(a, mid + 1, high);
            merge(a, low, mid, high);
        }
    }

    public void quickSort(Comparable a[], int low, int high) {
        if (low < high) {
            int pivotPos = partition(a, low, high);
            quickSort(a, low, pivotPos - 1);
            quickSort(a, pivotPos + 1, high);
        }
    }

    public void selectionSort(Comparable[] arr) {
        int len = arr.length;
        int min;
        for (int i = 0; i <= (len - 1); i++) {
            min = i;
            for (int j = i + 1; j <= (len - 1); j++) {
                if (Utility.less(arr[j], arr[min])) {
                    min = j;
                }
            }

            if (min != i) {
                Utility.swap(arr, min, i);
            }
        }
    }

    private int partition(Comparable a[], int low, int high) {
        int i = low - 1;
        Comparable pivot = a[high];

        for (int j = low; j < high; j++) {
            if (a[j].compareTo(pivot) <= 0) {
                i++;
                Utility.swap(a, i, j);
            }
        }

        Utility.swap(a, i + 1, high);

        return i + 1;
    }

    private void merge(int[] arr, int low, int mid, int high) {
        int[] firstHalf = new int[mid - low + 1];
        int[] secondHalf = new int[high - mid];

        int firstIndex = 0;
        int secondIndex = 0;
        int index = low;

        for (int i = low; i <= mid; i++) {
            firstHalf[firstIndex++] = arr[i];
        }

        for (int j = mid + 1; j <= high; j++) {
            secondHalf[secondIndex++] = arr[j];
        }

        firstIndex = secondIndex = 0;
        while (firstIndex < firstHalf.length && secondIndex < secondHalf.length) {
            if (firstHalf[firstIndex] <= secondHalf[secondIndex]) {
                arr[index++] = firstHalf[firstIndex++];
            } else if (secondHalf[secondIndex] <= firstHalf[firstIndex]) {
                arr[index++] = secondHalf[secondIndex++];
            }
        }

        // copy the remaining elements
        if (secondIndex == secondHalf.length) {
            for (int l = firstIndex; l < firstHalf.length; l++) {
                arr[index++] = firstHalf[l];
            }
        } else if (firstIndex == firstHalf.length) {
            for (int m = secondIndex; m < secondHalf.length; m++) {
                arr[index++] = secondHalf[m];
            }
        }

    }
}
