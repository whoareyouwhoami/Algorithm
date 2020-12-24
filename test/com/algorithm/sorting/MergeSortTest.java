package com.algorithm.sorting;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class MergeSortTest {

    @Test
    public void test1() {
        MergeSort s = new MergeSort();
        assertThat(s.mergeSort(new int[] {5, 1, 3, 2, 4}), is(new int[] {1, 2, 3, 4, 5}));
    }

    @Test
    public void test2() {
        MergeSort s = new MergeSort();
        assertThat(s.mergeSort(new int[] {17, 200, 10, 5}), is(new int[] {5, 10, 17, 200}));
    }

    @Test
    public void test3() {
        MergeSort s = new MergeSort();
        assertThat(s.mergeSort(new int[] {15, 13, 1, 7, 20, 11, 3, 6, 8, 4, 19, 14, 2, 0, 9}), is(new int[] {0, 1, 2, 3, 4, 6, 7, 8, 9, 11, 13, 14, 15, 19, 20}));
    }
}
