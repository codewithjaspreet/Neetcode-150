package com.company.LinkedList;

public class ReorderLL {

    static class ListNode {

        ListNode next;
        int val;

        public ListNode(ListNode next, int val) {
            this.next = next;
            this.val = val;
        }

        ListNode(int val) {
            this.val = val;
        }
    }

    public void reorderList(ListNode head) {
        ListNode mid = getMiddle(head);
        ListNode first = head;
        ListNode second = Reverse(mid.next);
        mid.next = null;


        while(second != null){

            ListNode temp1 = first.next;
            first.next = second;
            ListNode temp2 = second.next;
            second.next = temp1;
            first = temp1;
            second = temp2;
        }




    }

    private static ListNode getMiddle(ListNode node){
        ListNode slow = node; ListNode fast = node;

        while(fast.next !=null && fast.next.next !=null){
            slow = slow.next;
            fast =fast.next.next;

        }

        return slow;
    }

    private static ListNode Reverse(ListNode node){
        ListNode prev= null;
        ListNode cur  = node;
        ListNode temp;

        while(cur !=null){
            temp = cur.next;
            cur.next = prev;
            prev  = cur;
            cur = temp;
        }
        return prev;
    }
}
