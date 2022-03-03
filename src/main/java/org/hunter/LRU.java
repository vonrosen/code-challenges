package org.hunter;

import java.util.HashMap;
import java.util.Map;

//time(get/add)=O(N) space=O(2N)=O(N)
public class LRU{

	private static final int MAX = 2;

	private Map<String,Object> cache = new HashMap<>();
	private LinkedList list = new LinkedList();

	public static void main(String [] args){
		LRU lru = new LRU();
		lru.add("1", "1");
		lru.add("2", "2");
		System.out.println(lru.get("1"));
		System.out.println(lru.get("2"));
		lru.add("3", "3");
		//should be null
		System.out.println(lru.get("1"));
		//should not be null
		System.out.println(lru.get("2"));
		lru.add("4", "4");
		//should not be null
		System.out.println(lru.get("3"));
	}

	public void add(String id, Object object){
		if(cache.size() == MAX){
			cache.remove(list.head.object);
			list.delete(list.head.object);
		}
		cache.put(id, object);
		list.add(id);
	}

	public Object get(String id){
		Object object = cache.get(id);
		if(object != null){
			list.delete(id);
			list.add(id);
		}
		return object;
	}

	class LinkedList{
		LinkedListNode head;
		LinkedListNode tail;
		class LinkedListNode{
			LinkedListNode(Object object){
				this.object = object;
			}
			Object object;
			LinkedListNode next;
			LinkedListNode prev;
		}

		void add(Object object){
			if(head == null){
				head = new LinkedListNode(object);
				tail = head;
				return;
			}
			LinkedListNode tmp = head;
			while(tmp.next != null){
				tmp	= tmp.next;
			}
			tmp.next = new LinkedListNode(object);
			tmp.next.prev = tmp;
			tail = tmp.next;
		}

		void delete(Object object){
			if(head == null){
				return;
			}
			LinkedListNode tmp = head;
			while(tmp != null){
				if(object.equals(tmp.object)){
					if(tmp.prev == null){
						tmp = tmp.next;
					}else{
						tmp.prev = tmp.next;
					}
					return;
				}
				tmp = tmp.next;
			}
		}
	}
}
