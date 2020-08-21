package com.lixiande.leetcode;

import java.util.ArrayList;
import java.util.List;

public class leetcode1512 {
    public int solve(int [] nums){
        int ans = 0;
        int [] tables = new int[101];
        for(int i: nums){
            ans+= tables[i]++;
        }
        return ans;
    }
}
