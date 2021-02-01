package com.algorithm.graph;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class DijkstraTest {

    @Test
    public void test1() {
        int[][] matrix = {{0, 5, 0, 8, 0}, {0, 0, 6, 9, 0}, {0, 0, 0, 0, 4}, {0, 0, 2, 0, 7}, {0, 6, 0, 0, 0}};
        Dijkstra d = new Dijkstra(matrix);
        assertThat(d.dijkstra(0, 4), is(14));
    }

    @Test
    public void test2() {
        int[][] matrix = {{0, 4, 0, 0, 0, 0, 0, 8, 0}, {4, 0, 8, 0, 0, 0, 0, 11, 0}, {0, 8, 0, 7, 0, 4, 0, 0, 2}, {0, 0, 7, 0, 9, 14, 0, 0, 0}, {0, 0, 0, 9, 0, 10, 0, 0, 0}, {0, 0, 4, 14, 10, 0, 2, 0, 0}, {0, 0, 0, 0, 0, 2, 0, 1, 6}, {8, 11, 0, 0, 0, 0, 1, 0, 7}, {0, 0, 2, 0, 0, 0, 6, 7, 0}};
        Dijkstra d = new Dijkstra(matrix);
        assertThat(d.dijkstra(0, 4), is(21));
    }

    @Test
    public void test3() {
        int[][] matrix = {{0, 4, 0, 0, 0, 0, 0, 8, 0}, {4, 0, 8, 0, 0, 0, 0, 11, 0}, {0, 8, 0, 7, 0, 4, 0, 0, 2}, {0, 0, 7, 0, 9, 14, 0, 0, 0}, {0, 0, 0, 9, 0, 10, 0, 0, 0}, {0, 0, 4, 14, 10, 0, 2, 0, 0}, {0, 0, 0, 0, 0, 2, 0, 1, 6}, {8, 11, 0, 0, 0, 0, 1, 0, 7}, {0, 0, 2, 0, 0, 0, 6, 7, 0}};
        Dijkstra d = new Dijkstra(matrix);
        assertThat(d.dijkstra(0, 7), is(8));
    }
}
