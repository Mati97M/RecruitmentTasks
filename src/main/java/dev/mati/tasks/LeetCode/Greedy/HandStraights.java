package dev.mati.tasks.LeetCode.Greedy;

import java.util.HashMap;
import java.util.PriorityQueue;

public class HandStraights {
    public static void main(String[] args) {
        int[] hand = {3,4,7,4,6,3,6,5,2,8};
        System.out.println(new HandStraights().isNStraightHand(hand, 2));
    }
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if(n % groupSize != 0) {
            return false;
        }
        int groupsNum = n / groupSize;
        HashMap<Integer, Integer> cardsCounter = new HashMap<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int c: hand) {
            if(!cardsCounter.containsKey(c)) {
                minHeap.offer(c);
            }
            cardsCounter.put(c, cardsCounter.getOrDefault(c, 0) + 1);
        }
        for(int g = 0; g < groupsNum; g++) {
            if(minHeap.isEmpty()) {
                return false;
            }
            int curr = minHeap.peek();
            while(!minHeap.isEmpty() && cardsCounter.get(curr) <= 0) {
                minHeap.poll();
                curr = minHeap.peek();
            }
            cardsCounter.put(curr, cardsCounter.get(curr) - 1);
            if(cardsCounter.get(curr) == 0) {
                minHeap.poll();
            }
            for(int i = 1; i < groupSize; i++) {
                int nxt = curr + 1;
                if(!cardsCounter.containsKey(nxt) || cardsCounter.get(nxt) <= 0) {
                    return false;
                }
                cardsCounter.put(nxt, cardsCounter.get(nxt) - 1);
                curr = nxt;
            }
        }
        return true;
    }
}
