package dev.mati.tasks.LeetCode.Greedy;

import java.io.*;
import java.util.*;

public class JumpGameShortest {
    private HashMap<Integer, HashSet<Integer>> indicesGraph = new HashMap<>();
    private int jumps = 0;
    private boolean[] vis;

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(new JumpGameShortest().jump(nums));
        nums = prepareBigArr();
        System.out.println(new JumpGameShortest().jump(nums));
    }

    public int jump(int[] nums) {
        int L = 0;
        int R = 0;
        int jumps = 0;
        while(R < nums.length - 1) {
            int newR = R;
            for(int i = L; i <= R; i++) {
                newR = Integer.max(newR, i + nums[i]);
            }
            L = R + 1;
            R = newR;
            jumps++;
        }
        return jumps;
    }

    public int jumpBFS(int[] nums) { // unfortunately, too slow on LeetCode (time limit exceeded)
        vis = new boolean[nums.length];
        //prepare graph
        for(int i = 0; i < nums.length; i++) {
            indicesGraph.put(i, new HashSet<>());
            int steps = nums[i];
            for(int j = i + 1; steps > 0 && j < nums.length ; j++, steps--) {
                indicesGraph.get(i).add(j);
            }
        }
        //run bfs
        bfs();
        return jumps;
    }
    private void bfs() {
        LinkedList<Integer> q = new LinkedList<>();
        q.offer(0);
        vis[0] = true;
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                int polled = q.poll();
                for(int i: indicesGraph.get(polled)) {
                    if(!vis[i]) {
                        q.offer(i);
                        vis[i] = true;
                    }
                }
            }
            if(!q.isEmpty()) {
                jumps++;
            }
        }
    }
    private static int[] prepareBigArr() {
        int[] intArr = null;
        try(BufferedReader br
                    = new BufferedReader(new FileReader("src/main/java/dev/mati/tasks/LeetCode/Greedy/bigArr.txt"))) {
            String[] strArr = br.readLine().split(",");
            intArr = new int[strArr.length];
            for(int i = 0; i < intArr.length; i++) {
                intArr[i] = Integer.parseInt(strArr[i]);
            }
            return intArr;
        } catch (IOException e) {
            System.out.println("Could not create the reaquested array");;
        }
        return intArr;
    }
}
