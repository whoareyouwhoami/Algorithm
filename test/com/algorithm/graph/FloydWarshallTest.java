package com.algorithm.graph;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class FloydWarshallTest {

    @Test
    public void test1() {
        int[][] graph = {{0, 3, 0, 7}, {8, 0, 2, 0}, {5, 0, 0, 1}, {2, 0, 0, 0}};
        FloydWarshall fw = new FloydWarshall();

        int[][] result = {{0, 3, 5, 6}, {5, 0, 2, 3}, {3, 6, 0, 1}, {2, 5, 7, 0}};
        assertThat(fw.floydWarshall(graph), is(result));
    }

    @Test
    public void test2() {
        int[][] graph = {{0, 5, 0, 10}, {0, 0, 3, 0}, {0, 0, 0, 1}, {0, 0, 0, 0}};
        FloydWarshall fw = new FloydWarshall();

        int[][] result = {{0, 5, 8, 9}, {Integer.MAX_VALUE, 0, 3, 4}, {Integer.MAX_VALUE, Integer.MAX_VALUE, 0, 1}, {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 0}};
        assertThat(fw.floydWarshall(graph), is(result));
    }

}
