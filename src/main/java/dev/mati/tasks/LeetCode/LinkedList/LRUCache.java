package dev.mati.tasks.LeetCode.LinkedList;

import java.util.HashMap;

public class LRUCache {
    private HashMap<Integer,CacheNode> cacheNodes = new HashMap<>();
    private int capacity;
    private CacheNode left; //Least Recently Used
    private CacheNode right; //Most Recently Used

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1,1); //null
        cache.put(2,2); //null
        System.out.println(cache.get(1));   //1
        cache.put(3,3); //null
        System.out.println(cache.get(2));   //-1
        cache.put(4,4); //null
        System.out.println(cache.get(1));   //-1
        System.out.println(cache.get(3));   //3
        System.out.println(cache.get(4));   //4

    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        left = new CacheNode(0,0);
        right = new CacheNode(0,0);
        left.next = right;
        right.prev = left;
    }
    private void removeNodeFromList(CacheNode node) {//removes from list
        CacheNode prev = node.prev;
        CacheNode nxt = node.next;
        prev.next = nxt;
        nxt.prev = prev;
    }
    private void insertNodeIntoList(CacheNode node) {//inserts before rigth
        CacheNode prev = right.prev;
        prev.next = node;
        node.prev = prev;;
        right.prev = node;
        node.next = right;
    }

    public int get(int key) {
        if(cacheNodes.containsKey(key)) {
            CacheNode node = cacheNodes.get(key);
            removeNodeFromList(node);
            insertNodeIntoList(node);
            return node.val;
        } else
            return -1;
    }

    public void put(int key, int value) {
        CacheNode node = cacheNodes.get(key);
        if(node != null) {
            removeNodeFromList(node);
            node.val = value;
        } else {
            node = new CacheNode(key,value);
        }
        cacheNodes.put(key,node);
        insertNodeIntoList(node);

        if(cacheNodes.size() > capacity) {
            cacheNodes.remove(left.next.key);
            removeNodeFromList(left.next);
        }

    }
}
class CacheNode {
    int key;
    int val;
    CacheNode next;
    CacheNode prev;

    public CacheNode(int key, int val) {
        this.key = key;
        this.val = val;
    }

}
