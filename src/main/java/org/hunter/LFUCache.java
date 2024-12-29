package org.hunter;

class CacheLinkList{
    int key;
    int value;
    int useCount;
    int size = 0;
    CacheLinkList head;
    CacheLinkList tail;
    CacheLinkList next;
    CacheLinkList prev;

    CacheLinkList(){        
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
        node.prev = null;
        node.next = null;
        if(tail == null){
            head = node;
            tail = node;
            return;
        }
        if(head == tail){
            head.next = node;
            node.prev = head;
            tail = node;
            return;
        }
        tail.next = node;
        node.prev = tail;
        tail = node;
    }

    void remove(CacheLinkList list){
        if(head == null){
            size = 0;
            return;
        }
        if(head == tail){
            head = null;
            tail = null;
            size = 0;
            return;
        }
        --size;
        if(head == list){
            head = head.next;
            head.prev = null;
            return;
        }
        if(tail == list){
            tail.prev.next = null;
            tail = tail.prev;
            return;
        }
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
            cache.remove(list.head.key);
            list.remove(list.head);            
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
