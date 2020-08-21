package com.lixiande.leetcode;

public class GetKthMagicNumber {
    class Solution {
        public int getKthMagicNumber(int k) {
            int[] Kth = new int[k+1];
            int p3 = 0, p5 = 0, p7 = 0;
            Kth[0] = 1;
            for(int i =1; i< k; i++){
                Kth[i] = Math.min(Math.min(Kth[p3],Kth[p5]), Kth[p7]);
                if(Kth[i] == Kth[p3]) p3++;
                if(Kth[i] == Kth[p5]) p5++;
                if(Kth[i] == Kth[p7]) p7++;
            }
            return Kth[k-1];

        }
    }
}
