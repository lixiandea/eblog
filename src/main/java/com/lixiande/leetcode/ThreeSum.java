package com.lixiande.leetcode;

import java.util.*;

public class ThreeSum {
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            int n = nums.length;
            Arrays.sort(nums);
            List<List<Integer>> ans = new ArrayList<List<Integer>>();
            // 枚举 a
            for(int i = 0; i< n ; i++){
                if(nums[i] > 0) return ans;
                else {
                    if(i>0&& nums[i] == nums[i-1]) continue;
                    else {
                        int L = i+1;
                        int R = n-1;
                        while (L< R){
                            int sum = nums[i] + nums[L] + nums[R];
                            if(sum == 0) {
                                ans.add(Arrays.asList(nums[i] ,nums[L], nums[R]));
                                while (L > R && nums[L] == nums[L+1]) L++;
                                while (L< R && nums[R]== nums[R-1] ) R--;
                                L++;
                                R--;
                            }else {
                                if(sum> 0) R--;
                                if(sum< 0) L++;
                            }
                        }
                    }
                }
            }
            return ans;
        }
    }

}
