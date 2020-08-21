package com.lixiande.leetcode;


import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;

public class NumSquares {
    static class Solution {
        public int numSquares(int n) {
            int max = (int) Math.sqrt(n);
            HashSet<Integer> visited=new HashSet<>();
            Queue<Integer> q = new LinkedList<>();
            q.offer(n);
            visited.add(n);
            int [] nums = new int[max];
            int step = 0;
            for(int i=1;i<=max;i++) nums[i-1] = i*i;
            while (!q.isEmpty()){
                int sz = q.size();
                for(int i =0; i< sz;i++){
                    int cur = q.poll();
                    if(cur==0) return step;
                    else {
                        for(int num: nums){
                            if(!visited.contains(cur-num))
                            {
                                q.offer(cur-num);
                                visited.add(cur-num);
                            }
                        }
                    }
                }
                step++;
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println( s.numSquares(7168));
    }
}
