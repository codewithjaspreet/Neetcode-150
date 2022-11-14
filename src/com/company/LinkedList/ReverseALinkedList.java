package com.company.LinkedList;


 
class Solution {



 public static class ListNode{
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
    public ListNode reverseList(ListNode head) {
        
        ListNode temp;

        ListNode cur  = head;
        ListNode prev = null;

        while(cur!= null){

            temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;

        }

        return prev;

        

        
    }
}
