package com.lixiande.leetcode;

public class ArrayToBST {

    //Definition for a binary tree node.
     class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            return buildTree(nums,0, nums.length-1);
        }
        public TreeNode buildTree(int[] nums, int begin,int end){
            if(begin > end) return null;
            else {
                int mid = begin+(end-1)/2;
                System.out.println(mid);
                TreeNode root = new TreeNode(nums[mid]);
                root.left= buildTree(nums, begin, mid-1);
                root.right = buildTree(nums,mid+1,end);
                return root;
            }
        }
    }
}
