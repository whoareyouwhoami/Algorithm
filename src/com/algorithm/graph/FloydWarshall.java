package com.algorithm.graph;

public class FloydWarshall {
    /*
     * All pairs shortest path
     *
     * Time complexity: O(V^3)
     * Space complexity: O(V^2)
     */

    public int[][] floydWarshall(int[][] graph) {
        for (int row = 0; row < graph.length; row++) {
            for (int col = 0; col < graph[row].length; col++) {
                if (row != col && graph[row][col] == 0)
                    graph[row][col] = Integer.MAX_VALUE;
            }
        }

        for (int k = 0; k < graph.length; k++) {
            for (int r = 0; r < graph.length; r++) {
                for (int c = 0; c < graph[r].length; c++) {
                    int prevDist = Math.max(graph[r][k], graph[k][c]) == Integer.MAX_VALUE ? Integer.MAX_VALUE : graph[r][k] + graph[k][c];
                    graph[r][c] = Math.min(graph[r][c], prevDist);
                }
            }
        }

        return graph;
    }
}
