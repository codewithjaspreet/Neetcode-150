package com.company.heap;

import java.util.PriorityQueue;

class kthLargest {
    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int a : nums){

            pq.add(a);
        }

        while(k>1){

            pq.remove();
            k--;

        }

        return pq.poll();

    }
}