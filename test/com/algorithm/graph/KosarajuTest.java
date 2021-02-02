package com.algorithm.graph;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class KosarajuTest {

    @Test
    public void test1() {
        int[][] graph = {
                {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        Kosaraju k = new Kosaraju(graph);

        List<List<Integer>> output = k.kosarajuSCC();
        output.sort(
                (e1, e2) -> {
                    e1.sort(Comparator.naturalOrder());
                    e2.sort(Comparator.naturalOrder());
                    return e1.get(0) - e2.get(0);
                });

        int[][] r = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8, 9}, {10}};
        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i < r.length; i++) {
            result.add(new ArrayList<>());
        }

        for(int i = 0; i < r.length; i++) {
            for(int j = 0; j < r[i].length; j++) {
                result.get(i).add(r[i][j]);
            }
        }
        assertThat(output, is(result));
    }

    @Test
    public void test2() {
        int[][] graph = {
                {0, 0, 1, 1, 0},
                {1, 0, 0, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0}
        };

        Kosaraju k = new Kosaraju(graph);

        List<List<Integer>> output = k.kosarajuSCC();
        output.sort(
                (e1, e2) -> {
                    e1.sort(Comparator.naturalOrder());
                    e2.sort(Comparator.naturalOrder());
                    return e1.get(0) - e2.get(0);
                });

        int[][] r = {{0, 1, 2}, {3}, {4}};
        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i < r.length; i++) {
            result.add(new ArrayList<>());
        }

        for(int i = 0; i < r.length; i++) {
            for(int j = 0; j < r[i].length; j++) {
                result.get(i).add(r[i][j]);
            }
        }
        assertThat(output, is(result));
    }
}
