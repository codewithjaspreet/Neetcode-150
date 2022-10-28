package com.company.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class kClosestElements {

    static  class  Pair{

        int val;
        int diff;

        public Pair(int val, int diff) {
            this.val = val;
            this.diff = diff;
        }
    }

     static int[] closestElements(int[] arr , int k){

         int[] ans = new int[k];

         PriorityQueue<Pair> pq = new PriorityQueue<Pair>(Collections.reverseOrder());


         for(int a : arr){

             pq.add(new Pair(Math.abs(a  - k) , a ));

             if(pq.size() > k) pq.poll();
         }

         int i = 0;
         while (pq.size() > 0){
             ans[i] = pq.poll().val;
         }
         return  ans;

     }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int  k = 4 , x = 3;

        int[]ans  = closestElements(arr, k);
        System.out.println(ans.toString());
    }
}
