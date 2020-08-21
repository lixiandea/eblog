/*
package com.lixiande.leetcode;

import org.omg.CORBA.INTERNAL;

import java.lang.reflect.InvocationHandler;
import java.util.*;
import java.util.concurrent.BlockingQueue;

public class LoveStudy {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        int[] cost = new int [k];
        int [][] map = new int[n][n];
        int start ;
        int end ;
        int weight;
        Queue<Map.Entry<Integer,Integer>> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        HashMap<Integer, Integer> Distance = new HashMap<>();
        int curBest = Integer.MAX_VALUE;
        int curDay= 0;
        for(int i =0; i< m; i++){
            start = in.nextInt();
            end = in.nextInt();
            weight = in.nextInt();
            map[start-1][end - 1] = weight;
        }
        for(int i =0; i< k; ++i){
            cost[i] = in.nextInt();
        }
        visited.add(0);
        queue.offer(0);
        int sz;
        while (queue.isEmpty()){
            sz = queue.size();
            for(int i = 0; i< sz; ++i){
                int cur = queue.poll();
                if(!visited.contains(cur)){
                    for(int index =0; index< n; ++index){
                        if( index!= cur && map[cur][index] != 0){
                            queue.offer(index);
                        }
                    }
                }
            }


        }


    }
}
*/
