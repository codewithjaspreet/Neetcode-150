package com.company.LinkedList;

import com.company.LinkedList.AddTwoNumbers;

class DeleteNth {
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null || head.next==null) return null;
        int c=0;
        ListNode temp=head;
        while(temp!=null){
            temp=temp.next;
            c++;
        }
        if(n==c) return head.next;
        temp=head;
        for(int i=0; i<c-n-1; i++) temp=temp.next;
        if(n==1) temp.next=null;
        else temp.next=temp.next.next;
        return head;

    }
}