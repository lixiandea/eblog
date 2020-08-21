package com.lixiande.leetcode;


public class ClimbStairs {
    class Solution {
        public int climbStairs(int n) {
            if(n==1) return 1;
            if(n==2) return 2;
            int [] dp = new int [n+1];
            dp[1] = 1;
            dp[2] = 2;
            for(int index =3 ; index<=n;index++){
                dp[index] = dp[index-1]+dp[index-2];
            }
            return dp[n];
        }
    }
}
