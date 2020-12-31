package com.algorithm.graph;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PrimMSTTest {
    @Test
    public void test1() {
        int[][] g = {{0, 6, 0, 4, 0}, {6, 0, 10, 7, 7}, {0, 10, 0, 8, 5}, {4, 7, 8, 12}, {0, 7, 5, 12, 0}};
        PrimMST prim = new PrimMST();
        assertThat(prim.primMST(g), is(22));
    }

    @Test
    public void test2() {
        int[][] g = {{0, 2, 0, 6, 0}, {2, 0, 3, 8, 5}, {0, 3, 0, 0, 7}, {6, 8, 0, 0, 9}, {0, 5, 7, 9, 0}};
        PrimMST prim = new PrimMST();
        assertThat(prim.primMST(g), is(16));
    }

}
