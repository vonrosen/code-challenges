package org.hunter;

import java.util.HashMap;
import java.util.Map;

public class LRUCache2 {

    public static void main(String [] args) {

        LRUCache2 lruCache2 = new LRUCache2(2);
        lruCache2.put(1,1);
        lruCache2.put(2,2);
        System.out.println(lruCache2.get(1));
        lruCache2.put(3,3);
        System.out.println(lruCache2.get(2));

        //[[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
    }

    static class DoublyLinkedListNode {
        int key;
        int value;

        DoublyLinkedListNode head;
        DoublyLinkedListNode tail;
        DoublyLinkedListNode next;
        DoublyLinkedListNode prev;

        DoublyLinkedListNode(){
            head = new DoublyLinkedListNode(-1, -1);
            tail = new DoublyLinkedListNode(-1, -1);
            head.next = tail;
            tail.prev = head;
        }

        DoublyLinkedListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public void add(DoublyLinkedListNode node) {
            node.prev = tail.prev;
            node.next = tail;
            tail.prev.next = node;
            tail.prev = node;
        }

        public void delete(DoublyLinkedListNode node) {
            node.next.prev = node.prev;
            node.prev.next = node.next;
        }
    }


    private int capacity;
    private final Map<Integer,DoublyLinkedListNode> cache;
    private final DoublyLinkedListNode linkedList;

    LRUCache2(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        linkedList = new DoublyLinkedListNode();
    }

    int get(int key){
        if(cache.containsKey(key)) {
            linkedList.delete(cache.get(key));
            DoublyLinkedListNode node = new DoublyLinkedListNode(key, cache.get(key).value);
            linkedList.add(new DoublyLinkedListNode(key, cache.get(key).value));
            cache.put(key, node);
            return cache.get(key).value;
        }
        return -1;
    }

    void put(int key, int value) {
        if(cache.containsKey(key)){
            linkedList.delete(cache.get(key));
            DoublyLinkedListNode node = new DoublyLinkedListNode(key, value);
            cache.put(key, node);
            linkedList.add(node);
            return;
        }
        if(cache.size() == capacity){
            DoublyLinkedListNode node = new DoublyLinkedListNode(key, value);
            cache.remove(linkedList.head.next.key);
            linkedList.delete(linkedList.head.next);
            linkedList.add(node);
            cache.put(key, node);
            return;
        }
        DoublyLinkedListNode node = new DoublyLinkedListNode(key, value);
        linkedList.add(node);
        cache.put(key, node);
    }
}
