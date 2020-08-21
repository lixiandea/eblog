package com.lixiande.leetcode;

import java.util.Scanner;

public class NowCoder85N2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int [] cost = new int [n];
        for ( int i = 0 ; i < n; i++){
            cost[i] = in.nextInt();
        }
        /*int dp[][] = new int[n+1][m+1];
        for(int i = 1; i <= n; i++)
        {
            for(int j = 0; j <= m; j++)
            {
                if(j < cost[i-1])    dp[i][j]  = dp[i-1][j]; //不做i题
                else dp[i][j] =  Math.max(dp[i-1][j], dp[i-1][j - cost[i-1]] +1);
            }
        }*/
        int [] dp = new int [m+1];
        for(int i = 0; i < n; ++i)
        {
            for(int j = m; j >= cost[i]; --j)
                dp[j] =Math.max(dp[j], dp[j - cost[i]] + 1);
        }
        System.out.println(dp[m]);
    }

}
