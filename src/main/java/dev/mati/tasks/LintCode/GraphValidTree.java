package dev.mati.tasks.LintCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class GraphValidTree {
    private HashMap<Integer, HashSet<Integer>> connections = new HashMap<>();
    private HashSet<Integer> visited = new HashSet<>();

    public static void main(String[] args) {
        int[][] edges = {{0,1}, {1,4}, {1,2}, {2,3}, {1,3}};
        int n = 5;
        System.out.println(new GraphValidTree().validTree(n, edges));
    }
    public boolean validTree(int n, int[][] edges) {
        for(int i = 0; i < n; i++) {
            connections.put(i, new HashSet<>());
        }
        for(int[] edge: edges) {
            connections.get(edge[0]).add(edge[1]);
            connections.get(edge[1]).add(edge[0]);
        }
        if(!bfs(0))
            return false;
        return visited.size() == n;
    }
    private boolean bfs(int node) {
        LinkedList<Integer> q = new LinkedList<>();
        q.offer(node);
        visited.add(node);

        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int polled = q.poll();
                for(int n: connections.get(polled))
                    connections.get(n).remove(polled);
                for(int n: connections.get(polled)) {
                    if(visited.contains(n))
                        return false;
                    visited.add(n);
                    q.offer(n);
                }
            }
        }
        return true;
    }
}
