package com.company;

public class SortMain {

    public static void merge(int[] arr, int low, int mid, int high) {
        int[] firstHalf = new int[mid - low + 1];
        int[] secondHalf = new int[high - mid];

        int firstIndex = 0;
        int secondIndex = 0;
        int index = 0;

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

        if (firstHalf.length > secondHalf.length) {
            for (int l = firstIndex; l < firstHalf.length; l++) {
                arr[index++] = firstHalf[l];
            }
        } else {
            for (int m = secondIndex; m < secondHalf.length; m++) {
                arr[index++] = secondHalf[m];
            }
        }

    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 1, 4, 6};
        int low = 0;
        int high = arr.length;
        int mid = (low + high) / 2;
        merge(arr, low, mid, high - 1);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
