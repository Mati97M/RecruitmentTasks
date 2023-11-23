package dev.mati.tasks.LeetCode.HeapPriorityQueue;

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {
    public static void main(String[] args) {
        int[] stones = {2,7,4,1,8,1};
        System.out.println(new LastStoneWeight().lastStoneWeight(stones));
    }

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pqDesc = new PriorityQueue<>(Collections.reverseOrder());
        for(int s: stones)
            pqDesc.offer(s);

        while(pqDesc.size() > 1) {
            int s1 = pqDesc.poll();
            int s2 = pqDesc.poll();

            if(s1 == s2)
                continue;
            else {
                pqDesc.offer(s1 - s2);
            }
        }
        return (pqDesc.size() == 0) ? 0 : pqDesc.poll();
    }
}
