package com.company.trees;

public class subTreeOFAtree {
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
    class Solution {
        public boolean isSubtree(TreeNode root, TreeNode subRoot) {


            if(root == null) return false;

            if(isSame(root , subRoot)) return true;

            return isSubtree(root.left , subRoot) || isSubtree(root.right , subRoot);

        }



        static boolean isSame(TreeNode root1 , TreeNode root2){


            if(root1 == null && root2 != null ) return false;
            if(root2 == null && root1 != null) return false;

            if(root1 == null && root2 == null) return true;

            return root1.val == root2.val && isSame(root1.left , root2.left) && isSame(root1.right , root2.right) ;
        }


    }
}
