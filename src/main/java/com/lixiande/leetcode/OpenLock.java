package com.lixiande.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class OpenLock {
    static class Solution {
        public String plus(String s, int j) {
            char[] ch = s.toCharArray();
            if (ch[j] == '9') ch[j] = '0';
            else ch[j] += 1;
            return new String(ch);
        }

        public String minus(String s, int j) {
            char[] ch = s.toCharArray();
            if (ch[j] == '0') ch[j] = '9';
            else ch[j] -= 1;
            return new String(ch);
        }

        int openLock(String[] deadends, String target) {
            // 记录需要跳过的死亡密码
            Set<String> deads = new HashSet<>();
            for (String s : deadends) deads.add(s);
            // 记录已经穷举过的密码，防止走回头路
            Set<String> visited = new HashSet<>();
            Queue<String> q = new LinkedList<>();
            // 从起点开始启动广度优先搜索
            int step = 0;
            q.offer("0000");
            visited.add("0000");

            while (!q.isEmpty()) {
                int sz = q.size();
                /* 将当前队列中的所有节点向周围扩散 */
                for (int i = 0; i < sz; i++) {
                    String cur = q.poll();

                    /* 判断是否到达终点 */
                    if (deads.contains(cur))
                        continue;
                    if (cur.equals(target))
                        return step;

                    /* 将一个节点的未遍历相邻节点加入队列 */
                    for (int j = 0; j < 4; j++) {
                        String up = plus(cur, j);
                        if (!visited.contains(up)) {
                            q.offer(up);
                            visited.add(up);
                        }
                        String down = minus(cur, j);
                        if (!visited.contains(down)) {
                            q.offer(down);
                            visited.add(down);
                        }
                    }
                }
                /* 在这里增加步数 */
                step++;
            }
            // 如果穷举完都没找到目标密码，那就是找不到了
            return -1;
        }

    }

       /* public int openLock(String[] deadends, String target) {
            Queue<String> q = new LinkedList<>();
            Set<String> visited = new HashSet<>();
            Set<String> deads = new HashSet<>();
            int step = 0;
            for(String s: deadends) deads.add(s);
            q.offer("0000");
            visited.add("0000");
            while (!q.isEmpty()){
                    String cur = q.poll();
                    if(deads.contains(cur)) continue;
                    if(cur.equals(target)) return step;
                    for(int i =0; i< 4;i++){
                        String Up = plus(cur,i);
                        if(!visited.contains(Up)){
                            visited.add(Up);
                            q.offer(Up);
                        }
                        String down = minus(cur,i);
                        if(!visited.contains(down)){
                            visited.add(down);
                            q.offer(down);
                        }
                    }
                step++;
            }

            return -1;
        }
    }*/

    public static void main(String[] args) {
        Solution s = new Solution();
        s.openLock(new String[]{"8887","8889","8878","8898","8788","8988","7888","9888"},"8888");
    }
}
