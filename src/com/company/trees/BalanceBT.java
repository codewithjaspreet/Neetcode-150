package com.company.trees;


//brute force O(N^2);
class BalanceBT {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    static  class Pair {

        Boolean isBal;
        int  height;

        Pair() {
        }
        Pair(boolean isBal , int height) {

            this.isBal = isBal;
            this.height = height;
        }
    }

    static Pair balanceFast(TreeNode root) {

        if(root == null) {

            Pair base = new Pair(true , 0);
            return  base;
        }

        Pair left = balanceFast(root.left);

        Pair right = balanceFast(root.right);

       boolean leftAns = left.isBal;
       boolean rightAns = right.isBal;

       boolean diff = Math.abs(left.height - right.height) <=1 ;

       Pair ans = new Pair();

       ans.height = Math.max(left.height  ,right.height)  +1 ;

       if(leftAns && rightAns && diff) {

           ans.isBal = true;
       }

       else ans.isBal = false;

       return  ans;


    }






    static int height(TreeNode root ){

        if(root== null) return 0;
        return  1 + Math.max(height(root.left) , height(root.right));
    }

    public boolean isBalanced(TreeNode root) {

        if(root == null) return true;

        boolean left = isBalanced(root.left);

        boolean right = isBalanced(root.right);

        boolean diff = Math.abs(height(root.left)  - height(root.right)) <=1;

        if(left && right && diff) return true;

        else return false;

    }
}
}