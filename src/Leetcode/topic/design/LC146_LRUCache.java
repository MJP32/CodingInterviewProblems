package Leetcode.topic.design;

import java.util.HashMap;
import java.util.Map;

/**
        * Your LRUCache object will be instantiated and called as such:
        * LRUCache obj = new LRUCache(capacity);
        * int param_1 = obj.get(key);
        * obj.put(key,value);
        */
public class LC146_LRUCache {

    public int capacity;
    private int size;
    private DLinkedNode head, tail;
    private Map<Integer,DLinkedNode> cache = new HashMap<>();
    public LC146_LRUCache(int capacity) {
        this.capacity=capacity;
        this.size = 0;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;

            cache.put(key,newNode);
            addNode(newNode);
            ++size;

            if (size> capacity) {
                DLinkedNode tail = popTail();
                cache.remove(tail.key);
                --size;
            }
            else{
                node.value = value;
                moveToHead(node);
            }

        }
    }

    class DLinkedNode{
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
    }

    //Methods for doubly linked list
    private void addNode(DLinkedNode node){
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node){
        DLinkedNode prev = node.prev;
        DLinkedNode next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void moveToHead(DLinkedNode node){
        removeNode(node);
        addNode(node);
    }

    private DLinkedNode popTail(){
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }



}

