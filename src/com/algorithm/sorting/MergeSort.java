package com.algorithm.sorting;

import java.util.Arrays;

public class MergeSort {
    /*
     * Time complexity: O(nlog n)
     * Space complexity: O(n)
     */

    private int[] merge(int[] array1, int[] array2) {
        int idx = 0, idx1 = 0, idx2 = 0;
        int[] result = new int[array1.length + array2.length];

        while(idx1 < array1.length || idx2 < array2.length) {
            if(idx1 == array1.length)
                result[idx++] = array2[idx2++];
            else if(idx2 == array2.length)
                result[idx++] = array1[idx1++];
            else
                result[idx++] = array1[idx1] < array2[idx2] ? array1[idx1++] : array2[idx2++];
        }
        return result;
    }

    public int[] mergeSort(int[] array) {
        if(array.length == 1)
            return array;

        int mid = array.length / 2;
        int[] arrayLeft = mergeSort(Arrays.copyOfRange(array, 0, mid));
        int[] arrayRight = mergeSort(Arrays.copyOfRange(array, mid, array.length));

        return merge(arrayLeft, arrayRight);
    }
}
