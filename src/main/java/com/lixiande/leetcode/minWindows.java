/*
我再用java的string我就是臭傻逼
package com.lixiande.leetcode;

import java.util.HashMap;

public class minWindows {
    class Solution {
        public String minWindow(String s, String t) {
            char[] chs = s.toCharArray();
            char[] cht = t.toCharArray();
            HashMap<Character, Integer> window = new HashMap<>();
            HashMap<Character, Integer> need = new HashMap<>();
            int valid = 0;
            for(char c : cht) need.put(c, need.getOrDefault(c,0)+1);
            int res = Integer.MAX_VALUE;
            int l = 0;
            int r = 0;
            int start = 0;
            while (r< chs.length){
                char c = chs[r];
                r++;
                if(need.containsKey(c)){
                    window.put(c, window.getOrDefault(c,0)+1);
                    if(need.get(c) == window.get(c)){
                        valid++;
                    }
                }
                while (valid == need.size()){
                    if(r-l<res){
                        res = r-l;
                        start = l;
                    }
                    l++;
                    if(need.containsKey(chs[l-1])){
                        if(need.get(chs[l-1]) == window.get(chs[l-1])){
                            window.put(chs[l-1],window.get(chs[l-1]) - 1) ;
                            valid--;
                        }
                    }
                }
            }
            System.out.println();
            if(res == Integer.MAX_VALUE) return "";
            else return s.substring(start, start+res);
        }
    }
}
*/
