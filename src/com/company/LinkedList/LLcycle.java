package com.company.LinkedList;

import java.util.HashSet;

public class LLcycle {

    // brute spaced

    /**
     * Definition for singly-linked list.
     * class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    public class Solution {

        static  class ListNode{

            ListNode next;
            int data;

            public ListNode(ListNode next, int data) {
                this.next = next;
                this.data = data;
            }
        }
        public boolean hasCycle(ListNode head) {

            HashSet<ListNode> set = new HashSet<>();

            ListNode cur = head;

            while(cur != null){

                if(set.contains(cur)){

                    return true;
                }

                else{

                    set.add(cur);
                    cur = cur.next;
                }


            }

            return false;
        }
    }
}
