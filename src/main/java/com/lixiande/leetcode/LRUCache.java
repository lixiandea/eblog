package com.lixiande.leetcode;

import java.security.cert.TrustAnchor;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache<K, V> {
    class LRUCacheLinkedList<K,V>{
        int capcity;
        HashMap<K,V> data;
        LinkedList<K> list;
        public  LRUCacheLinkedList(int capcity){
            data = new HashMap<>(capcity);
            list = new LinkedList<>();
            this.capcity = capcity;
        }

        public V get(K key){
            if(data.containsKey(key)) return data.get(key);
            else return null;
        }

        public Boolean add(K key, V value){
            if(data.containsKey(key)){
                data.put(key,value);
                list.remove(list.indexOf(key));
                list.add(key);
            }
            else {
                if(data.size() < capcity){
                    list.add(key);
                }
                else {
                    list.remove(0);
                    list.add(key);
                }
            }
            return true;
        }
        public V remove(K key){
            list.remove(list.indexOf(key));
            V res = data.getOrDefault(key, null);
            data.remove(key);
            return res;
        }
    }

    class LRUCacheHashMap<K,V> {
        /*为什么不用LinkeList的Node类，非要自己写？
        因为LinkeList的Node类是private static的，所以要是想要用获得Node的地址就得自己实现
        * */
            class DLinkedNode {
                V value;
                DLinkedNode prev;
                DLinkedNode next;
                public DLinkedNode() {}
                public DLinkedNode( V _value) {value = _value;}
            }

            private Map<K, DLinkedNode> cache = new HashMap<>();
            private int size;
            private int capacity;
            private DLinkedNode head, tail;

            public LRUCacheHashMap(int capacity) {
                this.size = 0;
                this.capacity = capacity;
                // 使用伪头部和伪尾部节点
                head = new DLinkedNode();
                tail = new DLinkedNode();
                head.next = tail;
                tail.prev = head;
            }

            public V get(int key) {
                DLinkedNode node = cache.get(key);
                if (node == null) {
                    return null;
                }
                // 如果 key 存在，先通过哈希表定位，再移到头部
                moveToHead(node);
                return node.value;
            }

            public void put(K key, V value) {
                DLinkedNode node = cache.get(key);
                if (node == null) {
                    // 如果 key 不存在，创建一个新的节点
                    DLinkedNode newNode = new DLinkedNode( value);
                    // 添加进哈希表
                    cache.put(key, newNode);
                    // 添加至双向链表的头部
                    addToHead(newNode);
                    ++size;
                    if (size > capacity) {
                        // 如果超出容量，删除双向链表的尾部节点
                        DLinkedNode tail = removeTail();
                        // 删除哈希表中对应的项
                        cache.remove(key);
                        --size;
                    }
                }
                else {
                    // 如果 key 存在，先通过哈希表定位，再修改 value，并移到头部
                    node.value = value;
                    moveToHead(node);
                }
            }

            private void addToHead(DLinkedNode node) {
                node.prev = head;
                node.next = head.next;
                head.next.prev = node;
                head.next = node;
            }

            private void removeNode(DLinkedNode node) {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }

            private void moveToHead(DLinkedNode node) {
                removeNode(node);
                addToHead(node);
            }

            private DLinkedNode removeTail() {
                DLinkedNode res = tail.prev;
                removeNode(res);
                return res;
            }
        }
}

