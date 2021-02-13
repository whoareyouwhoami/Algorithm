package com.algorithm.graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class Kosaraju {
    /*
     * Strongly Connected Component
     *
     * Time complexity: O(V + E)
     * Space complexity: O(V)
     */

    private List<List<Integer>> graph = new ArrayList<>();
    private final int vtx;

    public Kosaraju(int[][] g) {
        vtx = g.length;

        for(int i = 0; i < vtx; i++) {
            graph.add(new ArrayList<>());
        }

        for(int r = 0; r < vtx; r++) {
            for(int c = 0; c < vtx; c++) {
                if(g[r][c] == 1) {
                    graph.get(r).add(c);
                }
            }
        }
    }

    private List<List<Integer>> reverseGraph() {
        List<List<Integer>> t = new ArrayList<>();

        for(int i = 0; i < vtx; i++) {
            t.add(new ArrayList<>());
        }

        for(int i = 0; i < graph.size(); i++) {
            int elem = graph.get(i).size();
            for(int j = 0; j < elem; j++) {
                t.get(graph.get(i).get(j)).add(i);
            }
        }
        return t;
    }

    private void DFS(Stack<Integer> stack, boolean[] visited, int v) {
        List<Integer> edges = graph.get(v);
        visited[v] = true;
        for(int e: edges) {
            if(!visited[e]) {
                DFS(stack, visited, e);
            }
        }
        stack.push(v);
    }

    private void DFSreverse(List<Integer> sc, boolean[] visited, int v) {
        List<Integer> edges = graph.get(v);
        visited[v] = true;
        sc.add(v);
        for(int e: edges) {
            if(!visited[e]) {
                DFSreverse(sc, visited, e);
            }
        }
    }

    public List<List<Integer>> kosarajuSCC() {
        List<List<Integer>> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[vtx];

        for(int i = 1; i < vtx; i++) {
            if(visited[i])
                continue;
            DFS(stack, visited, i);
        }

        graph = reverseGraph();

        visited = new boolean[vtx];
        while(!stack.isEmpty()) {
            int v = stack.pop();

            if (!visited[v]) {
                List<Integer> sc = new ArrayList<>();
                DFSreverse(sc, visited, v);
                result.add(sc);
            }
        }
        return result;
    }
}
