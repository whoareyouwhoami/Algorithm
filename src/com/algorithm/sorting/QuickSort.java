package com.algorithm.sorting;

public class QuickSort {
    private void swap(int[] array, int before, int after) {
        int tmp = array[after];
        array[after] = array[before];
        array[before] = tmp;
    }

    private int partition(int[] array, int low, int high) {
        int pivotVal = array[low];
        int pivotPos = low;
        int update = low;

        for(int i = low + 1; i < high; i++) {
            if(array[i] < pivotVal) {
                if(array[pivotPos] == pivotVal)
                    update = i;
                swap(array, i, pivotPos);
                pivotPos++;
            }
        }
        swap(array, update, pivotPos);
        return pivotPos;
    }

    private int[] quickSortRecur(int[] array, int low, int high) {
        if(low < high) {
            int pivot = partition(array, low, high);
            quickSortRecur(array, low, pivot);
            quickSortRecur(array, pivot + 1, high);
        }
        return array;
    }

    private int[] quickSort(int[] array) {
        return quickSortRecur(array, 0, array.length);
    }

    public static void main(String[] args) {
        QuickSort s = new QuickSort();
        int[] sorted = s.quickSort(new int[] {6, 1, 15, 9, 2, 23, 18, 3, 0, 31, 8, 7});

        System.out.print("Sorted: ");
        for(int x: sorted) {
            System.out.print(x + " ");
        }

        /*
         * Time complexity:
         *      - Worst case: O(n^2)
         *      - Average/Best case: O(nlog n)
         * Space complexity:
         *      - Worst case: O(n)
         *      - Average/Best case: O(log n) - partitioning + recursive calls
         */
    }
}
