package com.algorithm.sorting;

public class SelectionSort {
    private int[] selectionSort(int[] array) {
        for(int i = 0; i < array.length; i++) {
            int cur = array[i];
            int replace = i;

            for(int j = i; j < array.length; j++) {
                int min = array[j];
                if(min < cur) {
                    cur = min;
                    replace = j;
                }
            }

            int tmp = array[i];
            array[i] = array[replace];
            array[replace] = tmp;
        }

        return array;
    }

    public static void main(String[] args) {
        SelectionSort s = new SelectionSort();
        int[] sorted = s.selectionSort(new int[] {4, 3, 7, 5, 8, 6, 1, 9});

        System.out.println("Sorted: ");
        for(int x: sorted) {
            System.out.print(x + " ");
        }
    }
}
