package org.hunter;

class CacheLinkList{
    int key;
    int value;
    int useCount;
    int size = 0;
    CacheLinkList sentinel;
    CacheLinkList next;
    CacheLinkList prev;

    CacheLinkList(){
        sentinel = new CacheLinkList(-1, -1, -1);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;        
    }

    CacheLinkList(int key, int value, int useCount){
        this.key = key;
        this.value = value;
        this.useCount = useCount;
    }

    void add(int key, int value, int useCount){
        add(new CacheLinkList(key, value, useCount));
    }

    void add(CacheLinkList node){
        ++size;
        sentinel.prev.next = node;
        node.prev = sentinel.prev;
        node.next = sentinel;
        sentinel.prev = node;
    }

    void remove(CacheLinkList list){
        if(size == 0){
            return;
        }
        --size;
        list.prev.next = list.next;  
        list.next.prev = list.prev;
    }

    public String toString(){
        return key + " " + value + " " + useCount;
    }
}

class LFUCache {

    int minUseCount = 0;
    int capacity = 0;
    Map<Integer,CacheLinkList> cache;
    Map<Integer,CacheLinkList> counts;

    public LFUCache(int capacity) {
        this.cache = new HashMap<>();
        this.counts = new HashMap<>();
        this.capacity = capacity;
    }
    
    int update(int key, Integer val) {
        CacheLinkList value = cache.get(key);
        if(val != null){
            value.value = val;
        }
        CacheLinkList list = counts.get(value.useCount);
        if(value.useCount == minUseCount){
            if(list.size == 1){
                counts.remove(value.useCount);
                minUseCount++;
            }
        }        
        list.remove(value);
        list = counts.get(value.useCount + 1);
        if(list == null){
            list = new CacheLinkList();
        }
        CacheLinkList newNode = new CacheLinkList(key, value.value, value.useCount + 1);
        list.add(newNode);
        counts.put(value.useCount + 1, list);
        cache.put(key, newNode);
        return value.value;
    }

    public int get(int key) {
        if(cache.containsKey(key)){
            return update(key, null);
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            update(key, value);
            return;
        }
        if(cache.size() == capacity){                        
            CacheLinkList list = counts.get(minUseCount);            
            if(list.size == 1){
                counts.remove(minUseCount);
            }            
            cache.remove(list.sentinel.next.key);
            list.remove(list.sentinel.next);            
        }
        CacheLinkList list = counts.get(1);
        CacheLinkList newNode = new CacheLinkList(key, value, 1);
        if(list == null){
            list = new CacheLinkList();
        }
        list.add(newNode);
        counts.put(1, list);
        cache.put(key, newNode);
        minUseCount = 1;
    }
}
