package com.algorithm.sorting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestSort {
    @Test
    public void testSort1() {
        QuickSort q = new QuickSort();
        Assertions.assertArrayEquals(q.quickSort(new int[]{5, 4, 3, 2, 1}), new int[]{1, 2, 3, 4, 5});
    }
}
