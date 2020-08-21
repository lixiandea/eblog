package com.lixiande.leetcode;


import java.util.ArrayList;

//Definition for a binary tree node.


public class ValidateBST {
    class Solution {
        class TreeNode {
            int val;
            Solution.TreeNode left;
            Solution.TreeNode right;
            TreeNode(int x) { val = x; }
        }
        ArrayList<Integer> nodevals = new ArrayList<>();
        public boolean isValidBST(TreeNode root) {
            if(root == null) return true;
            NodeSecond(root);
            int pre = nodevals.get(0);
            for(int index = 1; index< nodevals.size(); index++){
                if(pre >= nodevals.get(index)) return  false;
                else {
                    pre = nodevals.get(index);
                }
            }
            return true;
        }
        public void NodeSecond(TreeNode root){
            if(root == null) return;
            else {
                NodeSecond(root.left);
                nodevals.add(root.val);
                NodeSecond(root.right);
            }
        }
    }

}
