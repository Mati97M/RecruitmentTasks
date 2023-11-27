package dev.mati.tasks.LeetCode.HeapPriorityQueue;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {
    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        mf.addNum(1);
        mf.addNum(2);
        System.out.println(mf.findMedian());
        mf.addNum(3);
        System.out.println(mf.findMedian());

    }
    PriorityQueue<Integer> smallNumsMaxHeap = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> bigNumsMinHeap = new PriorityQueue<>();

    public MedianFinder() {

    }

    public void addNum(int num) {
        smallNumsMaxHeap.add(num);
        if(smallNumsMaxHeap.size() > bigNumsMinHeap.size() + 1)
            bigNumsMinHeap.offer(smallNumsMaxHeap.poll());

        if(!bigNumsMinHeap.isEmpty() && smallNumsMaxHeap.peek() > bigNumsMinHeap.peek()) {
            int s = smallNumsMaxHeap.poll();
            int b = bigNumsMinHeap.poll();
            smallNumsMaxHeap.offer(b);
            bigNumsMinHeap.offer(s);
        }
    }

    public double findMedian() {
        if((smallNumsMaxHeap.size() + bigNumsMinHeap.size()) %2 != 0)
            return (double) smallNumsMaxHeap.peek();

        int s = smallNumsMaxHeap.peek();
        int b = bigNumsMinHeap.peek();
        return (s + b) / 2.;
    }
}
