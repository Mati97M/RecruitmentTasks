package dev.mati.tasks.LeetCode.Graphs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class CourseScheduleII {
    private HashMap<Integer, HashSet<Integer>> crsPrereq = new HashMap<>();
    private HashSet<Integer> crsVisited = new HashSet<>();
    private HashSet<Integer> cycle = new HashSet<>();
    private LinkedList<Integer> output = new LinkedList<>();

    public static void main(String[] args) {
        int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
        int numCourses = 4;
        System.out.println(Arrays.toString(new CourseScheduleII().findOrder(numCourses, prerequisites)));
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        for(int i = 0; i < numCourses; i++) {
            crsPrereq.put(i, new HashSet<>());
        }
        for(int[] cp: prerequisites)
            crsPrereq.get(cp[0]).add(cp[1]);

        for(int crs: crsPrereq.keySet()) {
            if(!dfs(crs))
                return new int[0];
        }
        return output.stream()
                .mapToInt(i -> (int) i)
                .toArray();
    }
    private boolean dfs(int crsNum) {
        if(cycle.contains(crsNum))
            return false;

        if(crsVisited.contains(crsNum))
            return true;

        cycle.add(crsNum);
        for(int p: crsPrereq.get(crsNum)) {
            if(!dfs(p))
                return false;
        }

        cycle.remove(crsNum);
        crsVisited.add(crsNum);
        output.add(crsNum);
        return true;
    }
}
