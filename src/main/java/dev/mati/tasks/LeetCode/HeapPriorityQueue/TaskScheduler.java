package dev.mati.tasks.LeetCode.HeapPriorityQueue;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class TaskScheduler {
    public static void main(String[] args) {
        char[] tasks = {'A','A','A','B','B','B'};
        int n = 2;
        System.out.println(new TaskScheduler().leastInterval(tasks, n));
    }
    public int leastInterval(char[] tasks, int n) {
        if(n == 0)
            return tasks.length;

        HashMap<Character, Integer> charsFreq = new HashMap<>();
        for(char t: tasks)
            charsFreq.put(t, charsFreq.getOrDefault(t, 0) + 1);

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int f: charsFreq.values())
            pq.offer(f);

        LinkedList<int[]> q = new LinkedList<>();
        int time = 0;
        while(!pq.isEmpty() || !q.isEmpty()) {
            time++;
            if(!pq.isEmpty()) {
                int curr = pq.poll();
                curr--;
                if(curr > 0)
                    q.offer(new int[] {curr, time + n});
            }
            if(!q.isEmpty() && q.peek()[1] == time) {
                pq.offer(q.poll()[0]);
            }
        }
        return time;
    }
}
