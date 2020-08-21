package com.lixiande.leetcode;

public class CountPrimes {
        static class Solution {
            public int countPrimes(int n) {
                if(n==2) return 1;
                else {
                    int res = 0;
                    boolean [] notPrimes = new boolean[n];
                    for(int i = 2; i*i < n ; i++){
                        if(!notPrimes[i]){
                            for(int j = i + i; j< n; j+=i){
                                notPrimes[j]= true;
                            }
                        }
                    }
                    for(boolean flag: notPrimes){
                        if(!flag){
                            ++res;
                        }

                    }
                    return res;
                }


            }
        }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.countPrimes(10);
    }

}
