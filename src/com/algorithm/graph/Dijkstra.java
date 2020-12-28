package com.algorithm.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra {
    /*
     * Time complexity: O((V + E) log V)
     * Space complexity: O(V)
     *
     * Note: TC can be expressed as O(E log V) since graph is connected
     */

    private final int[] distance;
    private final boolean[] visited;
    private final List<List<int[]>> edges = new ArrayList<>();

    /**
     *
     * @param mat Adjacency matrix with weight/distance
     */
    Dijkstra(int[][] mat) {
        int node = mat.length;
        visited = new boolean[node];
        distance = new int[node];
        Arrays.fill(distance, Integer.MAX_VALUE);

        for(int r = 0; r < mat.length; r++) {
            List<int[]> row = new ArrayList<>();
            for(int v = 0; v < node; v++) {
                if(mat[r][v] != 0)
                    row.add(new int[] {r, v, mat[r][v]});
            }
            edges.add(row);
        }
    }

    /**
     *
     * @param start  starting vertex
     * @param end  destination vertex
     * @return shortest distance
     */
    public int dijkstra(int start, int end) {
        // Priority Queue
        PriorityQueue<int[]> pq = new PriorityQueue<>((edg1, edg2) -> (edg1[2] - edg2[2]));

        // Set starting point 0
        distance[start] = 0;

        // Add initial vertex
        pq.add(new int[] {start, 0, 0});

        // Run
        while(!pq.isEmpty()) {
            int[] e = pq.poll();
            int next = e[1];

            if(visited[next])
                continue;

            visited[next] = true;

            for(int[] child: edges.get(next)) {
                int from = child[0];
                int to = child[1];
                int dist = child[2];

                // Relaxation
                int distanceNew = distance[from] + dist;
                if(!visited[to] && distanceNew < distance[to]) {
                    distance[to] = distanceNew;
                    child[2] = distanceNew;
                }

                pq.add(child);
            }
        }
        return distance[end];
    }
}
