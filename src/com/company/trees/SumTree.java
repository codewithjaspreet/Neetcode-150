package com.company.trees;

public class SumTree {

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(){};
        TreeNode(TreeNode left , TreeNode right , int val){
            this.left = left;
            this.val = val;
            this.right = right;
        }
    }

    static class  Pair{

        int sum;
        boolean isSum;

        Pair(){}
        Pair(int sum  ,boolean isSum){

            this.sum  = sum;
            this.isSum = isSum;
        }
    }


    static  boolean sumTree(TreeNode node){

        return  fastSum(node).isSum;
    }
    static Pair fastSum(TreeNode node){

        if(node == null){

            Pair p  = new Pair(0 , true);
            return  p;
        }
        if(node.left == null && node.right == null){

            Pair p = new Pair(node.val , true);
            return p;
        }
        Pair leftans = fastSum(node.left);
        Pair rightAns = fastSum(node.right);

        boolean left = leftans.isSum;
        boolean right = rightAns.isSum;

        boolean cond = node.val == leftans.sum + rightAns.sum;

        Pair p  = new Pair();

        if(left && right && cond){

            p.isSum = true;
            p.sum = 2 * node.val;
        }
        else{
            p.isSum = false;
        }

        return  p;
    }

}
