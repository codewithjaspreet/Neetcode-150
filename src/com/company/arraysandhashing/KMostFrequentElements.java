package com.company.arraysandhashing;

import java.util.*;

public class KMostFrequentElements {




    public static  int[] topKFrequent(int[] nums, int k) {

        int[] ans = new int[k];



        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a ,b) -> b[1] - a[1]);

        HashMap<Integer, Integer > map = new HashMap<>();
        for(int a  : nums) map.put(a , map.getOrDefault(a , 0) + 1);


        for (int key : map.keySet())
            priorityQueue.add(new int[]{key, map.get(key)});

        //Take the largest k elements in the heap
        int[] res = new int[k];
        for (int i = 0; i < k; i++)
            res[i] = priorityQueue.poll()[0];


        return ans;
    }

    public static void main(String[] args) {
        Scanner s  = new Scanner(System.in);

        int n = s.nextInt();

        int[] arr = new int[n];

        for(int i = 0  ; i  < arr.length ; i++){

            arr[i] = s.nextInt();
        }
        int  k = s.nextInt();

        System.out.println(topKFrequent(arr , k).toString());
    }
}
