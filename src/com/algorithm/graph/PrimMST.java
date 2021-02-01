package com.algorithm.graph;

import java.util.PriorityQueue;

public class PrimMST {
    /*
     * Time complexity: O(E log V)
     * Space complexity:
     *           PQ     visited
     *          O(E)  +  O(V)     = O(E)
     *
     * Note: With adjacency matrix, TC is O(V^2)
     */

    public int primMST(int[][] graph) {
        int cost = 0;
        boolean[] visited = new boolean[graph.length];

        PriorityQueue<int[]> pq = new PriorityQueue<>((edg1, edg2) -> (edg1[1] - edg2[1]));

        // Start from vertex 0
        pq.add(new int[]{0, 0});

        while (!pq.isEmpty()) {
            int[] edge = pq.poll();
            int from = edge[0], dist = edge[1];

            if (visited[from])
                continue;

            visited[from] = true;

            cost += dist; // Update distance

            for (int col = 0; col < graph[from].length; col++) {
                if (graph[from][col] > 0 && !visited[col])
                    pq.add(new int[]{col, graph[from][col]});
            }
        }
        return cost;
    }
}
