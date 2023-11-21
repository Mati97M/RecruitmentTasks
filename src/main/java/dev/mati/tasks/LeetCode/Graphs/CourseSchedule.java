package dev.mati.tasks.LeetCode.Graphs;

import java.util.HashMap;
import java.util.HashSet;

public class CourseSchedule {
    private HashMap<Integer, HashSet<Integer>> coursePrereq = new HashMap<>();
    private HashSet<Integer> VisitedCs = new HashSet<>();

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1,0},{0,1}};
        System.out.println(new CourseSchedule().canFinish(numCourses, prerequisites));
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for(int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int prereq = prerequisites[i][1];

            if(!coursePrereq.containsKey(course))
                coursePrereq.put(course, new HashSet<>());
            coursePrereq.get(course).add(prereq);
        }
        if(coursePrereq.size() > numCourses)
            return false;

        for(int crs: coursePrereq.keySet()) {
            if(!dfs(crs))
                return false;
        }
        return true;
    }
    private boolean dfs(int courseNum) {
        if(coursePrereq.get(courseNum) == null
                || coursePrereq.get(courseNum).isEmpty())
            return true;

        if(!VisitedCs.add(courseNum))
            return false;

        for(int prereq: coursePrereq.get(courseNum)) {
            if(!dfs(prereq))
                return false;
        }
        VisitedCs.remove(courseNum);
        coursePrereq.put(courseNum, null);
        return true;
    }
}
