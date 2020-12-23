package com.algorithm.sorting;

public class InsertionSort {
    public int[] insertionSort(int[] array) {
        for(int i = 1; i < array.length; i++) {
            for(int j = i; j > 0; j--) {

                if(array[j] < array[j - 1]) {
                    int tmp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = tmp;
                }
            }
        }
        return array;
    }
    public static void main(String[] args) {
        InsertionSort s = new InsertionSort();
        int[] sorted = s.insertionSort(new int[] {1, 9, 6, 5, 10, 2, 19, 7});

        System.out.println("Sorted: ");
        for(int x: sorted) {
            System.out.print(x + " ");
        }
    }
}
