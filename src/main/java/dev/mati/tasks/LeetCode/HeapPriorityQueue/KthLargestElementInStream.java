package dev.mati.tasks.LeetCode.HeapPriorityQueue;

import java.util.PriorityQueue;

public class KthLargestElementInStream {
    public static void main(String[] args) {
        int k = 3;
        int[] nums = {4, 5, 8, 2};
        KthLargestElementInStream kth = new KthLargestElementInStream(k,nums);
        System.out.println(kth.add(3));
        System.out.println(kth.add(5));
        System.out.println(kth.add(10));
        System.out.println(kth.add(9));
        System.out.println(kth.add(4));

    }
    private PriorityQueue<Integer> pq;
    private int k;
    public KthLargestElementInStream(int k, int[] nums) {
        this.k = k;
        this.pq = new PriorityQueue<Integer>();
        for(int n: nums)
            pq.offer(n);
    }

    public int add(int val) {
        pq.offer(val);
        while(pq.size() > k)
            pq.poll();

        return pq.peek();
    }
}
