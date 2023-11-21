package dev.mati.tasks.LeetCode.Graphs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class RedundantConnection {
    private HashMap<Integer, HashSet<Integer>> connections = new HashMap<>();
    private HashSet<Integer> visited = new HashSet<>();
    private int n;

    public static void main(String[] args) {
        int[][] edges = {{1,2},{2,3},{3,4},{1,4},{1,5}};
        System.out.println(Arrays.toString(new RedundantConnection().findRedundantConnection(edges)));
    }

    public int[] findRedundantConnection(int[][] edges) {
        n = edges.length;
        for(int i = 1; i < edges.length + 1; i++) {
            connections.put(i, new HashSet<>());
        }
        for(int[] edge: edges) {
            connections.get(edge[0]).add(edge[1]);
            connections.get(edge[1]).add(edge[0]);
        }
        for(int i = edges.length - 1; i >= 0; i--) {
            if(isValidTreeAfterRemoval(edges[i]))
                return edges[i];
        }
        return null;
    }
    private boolean isValidTreeAfterRemoval(int[] edge) {
        //remove Edge
        int a = edge[0];
        int b = edge[1];
        connections.get(a).remove(b);
        connections.get(b).remove(a);

        bfs();
        //check if it is valid with BST. It is not valid, if there remains any unvisited node
        if(visited.size() == n)
            return true;
        visited = new HashSet<Integer>();
        //add removed edges to connections
        connections.get(a).add(b);
        connections.get(b).add(a);
        return false;
    }
    private void bfs() {
        LinkedList<Integer> q = new LinkedList<>();
        q.addAll(connections.get(1));
        visited.add(1);

        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int polled = q.poll();
                visited.add(polled);
                HashSet<Integer> toVisit = connections.get(polled);
                for(int el: toVisit) {
                    if(!visited.contains(el)) {
                        q.offer(el);
                        visited.add(el);
                    }
                }
            }
        }
    }
}
