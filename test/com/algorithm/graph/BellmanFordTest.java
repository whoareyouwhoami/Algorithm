package com.algorithm.graph;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class BellmanFordTest {

    @Test
    public void test1() {
        int[][] graph = new int[][] {
                {0, 6, 5, 5, 0, 0, 0},
                {0, 0, 0, 0, -1, 0, 0},
                {0, -2, 0, 0, 1, 0, 0},
                {0, 0, -2, 0, 0, -1, 0},
                {0, 0, 0, 0, 0, 0, 3},
                {0, 0, 0, 0, 0, 0, 3},
                {0, 0, 0, 0, 0, 0, 0}
        };

        BellmanFord bf = new BellmanFord(graph);
        assertThat(bf.bellmanFord(3), is(5));
        assertThat(bf.bellmanFord(6), is(3));
    }

    @Test
    public void test2() {
        int[][] graph = new int[][] {
                {0, 4, 0, 5},
                {0, 0, 0, 0},
                {0, -10, 0, 0},
                {0, 0, 3, 0}
        };

        BellmanFord bf = new BellmanFord(graph);
        assertThat(bf.bellmanFord(1), is(-2));
        assertThat(bf.bellmanFord(2), is(8));

    }

    @Test
    public void testNegativeWeightCycle() {
        int[][] graph = new int[][] {
                {0, 4, 0, 5},
                {0, 0, 0, 5},
                {0, -10, 0, 0},
                {0, 0, 3, 0}
        };

        BellmanFord bf = new BellmanFord(graph);
        assertThat(bf.bellmanFord(2), is(Integer.MIN_VALUE));
        assertThat(bf.bellmanFord(3), is(Integer.MIN_VALUE));
    }
}
