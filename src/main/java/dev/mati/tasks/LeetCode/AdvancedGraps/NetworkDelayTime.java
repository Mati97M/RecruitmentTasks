package dev.mati.tasks.LeetCode.AdvancedGraps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class NetworkDelayTime {
    public static void main(String[] args) {
        int[][] times = {{2,1,1},{2,3,1},{3,4,1}};
        int n = 4;
        int k = 2;
        System.out.println(new NetworkDelayTime().networkDelayTime(times, n, k));
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer, Integer> visited = new HashMap<>();
        HashMap<Integer, ArrayList<int[]>> adjList = new HashMap<>();
        for(int i = 1; i <= n; i++)
            adjList.put(i, new ArrayList<>());
        for(int[] edge: times)
            adjList.get(edge[0]).add(new int[] {edge[1], edge[2]});
        PriorityQueue<int[]> minE = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        //Dijikstra
        for(int[] tW : adjList.get(k))
            minE.offer(tW);
        visited.put(k, 0);

        while(!minE.isEmpty()) {
            int[] currTW = minE.poll();
            if(visited.containsKey(currTW[0]))
                continue;
            visited.put(currTW[0], currTW[1]);
            for(int[] tW: adjList.get(currTW[0])) {
                if(visited.containsKey(tW[0]))
                    continue;
                tW[1] += currTW[1];
                minE.offer(tW);
            }
        }

        if(visited.keySet().size() < n)
            return -1;
        return Collections.max(visited.values());

    }
}
