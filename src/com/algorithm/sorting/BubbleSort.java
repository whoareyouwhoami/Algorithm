package com.algorithm.sorting;

public class BubbleSort {

    public int[] bubbleSort(int[] array) {
        for(int bound = array.length - 1; bound > -1; bound--) {
            for(int i = 0; i < bound; i++) {
                if (array[i] > array[i + 1]) {
                    int tmp = array[i + 1];
                    array[i + 1] = array[i];
                    array[i] = tmp;
                }
            }
        }
        return array;
    }
    public static void main(String[] args) {
        BubbleSort s = new BubbleSort();
        int[] sorted = s.bubbleSort(new int[] {5, 0, 9, 3, 8, 6, 1, 7});

        System.out.print("Sorted: ");
        for(int x: sorted) {
            System.out.print(x + " ");
        }
        /*
         * Time complexity: O(n^2)
         * Space complexity: O(1)
         */
    }
}
