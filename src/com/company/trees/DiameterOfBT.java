package com.company.trees;

class Solution {

    static class Node{
        Node left;
        Node right;

        Node(){


        }
    }

    // Function to return the diameter of a Binary Tree.
    int diameter(Node root) {
        // Your code here

        if(root == null) return 0;

        int op1 = diameter(root.left);
        int op2 = diameter(root.right);

        int op3 = height(root.left) + 1 + height(root.right);

        return Math.max(op1 , Math.max(op2 ,op3));


    }

    public static int height(Node root ){

        if(root == null) return 0;


        return 1 + Math.max(height(root.left) , height(root.right));

    }


}
