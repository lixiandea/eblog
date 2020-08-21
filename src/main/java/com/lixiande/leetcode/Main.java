package com.lixiande.leetcode;

import java.util.*;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class Main {
    public static void main(String[] args) {
        int res = 0;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n == 0){
            System.out.println(res);
            return;
        }
        //HashSet<String > city = new LinkedHashSet<>();
        Stack<String> cities = new Stack<>();
        for(int index = 0; index < n; index++){
            String cur = sc.next();
            if(cities.size() == 0){
                cities.push(cur);
            }else {
                if(cities.get(0).equals(cur)){
                    res += 1;
                    cities.clear();
                }
            }
        }
        System.out.println(res);
        return;
        AbstractQueuedSynchronizer
    }
}
