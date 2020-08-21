package com.lixiande.leetcode;


import java.util.ArrayList;
import java.util.List;

// Definition for a binary tree node.

public class BFSTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            ArrayList<List<Integer>> res = new ArrayList<>();
            if(root == null) return null;
            else {
                ArrayList<TreeNode> cur = new ArrayList<>();
                cur.add(root);
                while (cur.size()!=0){
                    ArrayList<TreeNode> temp = new ArrayList<>();
                    ArrayList<Integer> curRes = new ArrayList<>();
                    for(TreeNode node: cur){
                        if(node!= null){
                            curRes.add(node.val);
                            temp.add(node.left);
                            temp.add(node.right);
                        }
                    }
                    cur = temp;
                    if(curRes.size()!= 0){
                        res.add(curRes);
                    }

                }
                return res;
            }
        }
    }
}
