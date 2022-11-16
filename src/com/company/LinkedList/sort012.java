package com.company.LinkedList;


class Sort012
{

    static class Node{
        Node next;
        int data;

        public Node(Node next, int data) {
            this.next = next;
            this.data = data;
        }
        Node(int data){
            this.data = data;
        }
    }
    //Function to sort a linked list of 0s, 1s and 2s.
    class Solution
    {

        static Node segregate(Node head)
        {
            if(head == null || head.next == null) return head;
            Node zero = new Node(-1);
            Node pzero = zero;


            Node one = new Node(-1);
            Node pone  = one;


            Node two = new Node(-1);
            Node ptwo  = two;

            Node cur = head;

            while(cur != null){
                if(cur.data == 0){
                    pzero.next = cur;
                    pzero = pzero.next;
                }
                else if(cur.data == 1){
                    pone.next = cur;
                    pone = pone.next;
                }

                else{
                    ptwo.next = cur;
                    ptwo = ptwo.next;
                }
                cur = cur.next;
            }
            pone.next = two.next;
            pzero.next = one.next;

            ptwo.next = null;

            return zero.next;



            // add your code here
        }
    }


    // add you
//        int zero = 0 ; int one = 0; int two = 0;
//
//        Node temp = head;
//
//        while(temp!= null){
//
//            if(temp.data == 0) zero++;
//            else if(temp.data == 1) one++;
//            else two++;
//
//            temp = temp.next;
//        }
//
//        temp = head;
//
//        while(zero > 0 ){
//
//            temp.data = 0;
//            temp = temp.next;
//            zero--;
//        }
//
//        while(one > 0 ){
//
//            temp.data = 1;
//            temp = temp.next;
//            one--;
//        }
//
//        while(two > 0 ){
//
//            temp.data = 2;
//            temp = temp.next;
//            two--;
//        }
//
//        return head;
//
//
//    }
}


