package com.company.trees;

public class SameTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val,TreeNode left,TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    static  boolean isSame(TreeNode p , TreeNode q){

        if(p == null && q == null) return  true;
        if(p == null && q !=null) return  false;
        if(q == null && p != null) return  false;

        return (isSame(p.left, q.left) && isSame(p.right , q.right) && p.val == q.val);


    }
}
