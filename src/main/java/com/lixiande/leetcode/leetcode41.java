//package com.lixiande.leetcode;
//
//import java.util.*;
// class Solution {
//
//    private int[] parent;
//
//    // 交换字符串中的元素
//    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
//        int n = s.length();
//        parent = new int[n];
//        for (int i = 0; i < n; i++) {
//            parent[i] = i;
//        }
//        for (List<Integer> pair : pairs) {
//            union(pair.get(0), pair.get(1));
//        }
//        Map<Integer, PriorityQueue<String>> map = new HashMap<>();
//        for (int i = 0; i < n; i++) {
//            map.computeIfAbsent(find(i), v -> new PriorityQueue<>()).add(String.valueOf(s.charAt(i)));
//        }
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < n; i++) {
//            sb.append(map.get(find(i)).poll());
//        }
//        return sb.toString();
//    }
//
//    private int find(int node) {
//        return parent[node] == node ? node : (parent[node] = find(parent[node]));
//    }
//
//    private void union(int node1, int node2) {
//        int root1 = find(node1);
//        int root2 = find(node2);
//        if (root1 == root2) {
//            return;
//        }
//        parent[root1] = root2;
//    }
//}
//public class leetcode41 {
//
//
//    public static void main(String[] args) {
//        Solution s = new Solution();
//
//    }
//}
