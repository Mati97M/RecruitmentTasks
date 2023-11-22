package dev.mati.tasks.LintCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class ComponentsNumUndirectedGraph { //to do: solve this task with union find
    private HashSet<Integer> visited = new HashSet<>();
    private HashMap<Integer, HashSet<Integer>> connections = new HashMap<>();

    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {{0,1}, {1,2}, {2, 3}, {4, 5}};
        System.out.println(new ComponentsNumUndirectedGraph().countComponents(n, edges));
    }

    public int countComponents(int n, int[][] edges) {
        int ComponentCount = 0;
        for(int[] edge: edges) {
            if(!connections.containsKey(edge[0]))
                connections.put(edge[0], new HashSet<>());
            if(!connections.containsKey(edge[1]))
                connections.put(edge[1], new HashSet<>());
            connections.get(edge[0]).add(edge[1]);
            connections.get(edge[1]).add(edge[0]);
        }
        for(int key: connections.keySet()) {
            if(!visited.contains(key)) {
                bfs(key);
                ComponentCount++;
            }
        }
        while(n > connections.keySet().size()) {
            ComponentCount++;
            n--;
        }
        return ComponentCount;
    }
    private void bfs(int node) {
        LinkedList<Integer> q = new LinkedList<>();
        q.addAll(connections.get(node));
        visited.add(node);

        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int polled = q.poll();
                visited.add(polled);
                for(int nd: connections.get(polled)) {
                    if(!visited.contains(nd))
                        q.add(nd);
                }
            }
        }
    }
}
