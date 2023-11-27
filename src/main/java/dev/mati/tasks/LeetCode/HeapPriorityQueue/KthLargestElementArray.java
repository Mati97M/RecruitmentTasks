package dev.mati.tasks.LeetCode.HeapPriorityQueue;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElementArray {   //to do: quick select
    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        System.out.println(new KthLargestElementArray().findKthLargest(nums, k));
    }
    private int hLindex;
    public int findKthLargest(int[] nums, int k) {
        int[] maxHeap = new int[nums.length + 1];
        maxHeap[0] = 0;
        for(int i = 0; i < nums.length; i++)
            maxHeap[i + 1] = nums[i];

        heapifyMax(maxHeap);
        for(int i = 1; i < k; i++)
            pop(maxHeap);

        return pop(maxHeap);
    }
    private void heapifyMax(int[] heap) {
        this.hLindex = heap.length - 1;
        int curr = (heap.length - 1) / 2;
        while(curr > 0) {
            percolateDown(heap, curr);
            curr--;
        }
    }
    private void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
    private int pop(int[] maxHeap) {
        int res = maxHeap[1];
        maxHeap[1] = maxHeap[hLindex];
        this.hLindex--;
        percolateDown(maxHeap, 1);
        return res;
    }
    private void percolateDown(int[] maxHeap, int curr) {
        int i = curr;
        int r = 2 * i + 1;
        int l = 2 * i;
        while(l <= hLindex) {
            if(r <= hLindex
                    && maxHeap[r] > maxHeap[l]
                    && maxHeap[r] > maxHeap[i]) {
                swap(maxHeap, i, r);
                i = r;
                r = 2 * i + 1;
                l = 2 * i;
            } else if (maxHeap[l] > maxHeap[i]) {
                swap(maxHeap, i, l);
                i = l;
                r = 2 * i + 1;
                l = 2 * i;
            } else
                break;
        }
    }

    public int findKthLargestPQ(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int n: nums)
            pq.offer(n);
        while(pq.size() > k)
            pq.poll();

        return pq.peek();
    }

    public int findKthLargestSorting(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

}
