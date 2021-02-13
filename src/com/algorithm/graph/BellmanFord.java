package com.algorithm.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BellmanFord {
    /*
     * Time complexity: O(VE)
     * Space complexity: O(V)
     */

    private final int numVertex;
    private final int[] distance;
    private final List<List<int[]>> edges = new ArrayList<>();

    BellmanFord(int[][] graph) {
        numVertex = graph.length;
        distance = new int[numVertex];

        Arrays.fill(distance, Integer.MAX_VALUE);

        for (int r = 0; r < graph.length; r++) {
            List<int[]> row = new ArrayList<>();
            for (int v = 0; v < numVertex; v++) {
                if (graph[r][v] != 0)
                    row.add(new int[]{r, v, graph[r][v]});
            }
            edges.add(row);
        }
    }

    public int bellmanFord(int destination) {
        // Set starting vertex as 0
        distance[0] = 0;

        for (int i = 0; i < numVertex - 1; i++) {
            for (List<int[]> edge : edges) {
                for (int[] e : edge) {
                    int start = e[0], end = e[1], w = e[2];
                    if (distance[start] + w < distance[end]) {
                        distance[end] = distance[start] + w;
                    }
                }
            }
        }

        // Check for negative weight cycle
        for (List<int[]> edge : edges) {
            for (int[] e : edge) {
                int start = e[0], end = e[1], w = e[2];
                if (distance[start] + w < distance[end]) {
                    return Integer.MIN_VALUE;
                }
            }
        }
        return distance[destination];
    }
}
