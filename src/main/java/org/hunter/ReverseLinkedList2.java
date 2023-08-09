package org.hunter;

import java.util.ArrayList;
import java.util.List;

import org.hunter.LRU.LinkedList;

public class ReverseLinkedList2{

	public static void main(String [] args){
		ReverseLinkedList2 reverseLinkedList2 = new ReverseLinkedList2();
		LinkedListNode node = new LinkedListNode(1, null);
		node.next = new LinkedListNode(2, null);
		node.next.next = new LinkedListNode(3, null);
		node.next.next.next = new LinkedListNode(4, null);
		System.out.println(node);
		System.out.println(reverseLinkedList2.reverse(node));
	}

	public LinkedListNode reverse(LinkedListNode list){
		LinkedListNode next = list;
		LinkedListNode prev = null;
		LinkedListNode prevPrev = null;
		LinkedListNode nextNext = null;
		while(next != null){
			nextNext = next.next;
			next.next = prevPrev;
			prev = next;
			prevPrev = prev;
			next = nextNext;
		}
		return prev;
	}

	static class Stuff<T>{
		T t;
		Stuff(T t){
			this.t = t;
		}

		void eval(T param){
			System.out.println(param.equals(t));
		}
	}

	Stuff<?> getIt(){
		List<Stuff<?>> list = new ArrayList<>();
		list.add(new Stuff<>(1));
		list.add(new Stuff<>("a"));
		return list.get(0);
	}

	<T> void doIt(T param){
		Stuff<T> stuff = (Stuff<T>)getIt();
		stuff.eval(param);
	}

	static class LinkedListNode{
		LinkedListNode next;
		int value;

		LinkedListNode(int value, LinkedListNode next){
			this.value = value;
			this.next = next;
		}

		@Override
		public String toString(){
			LinkedListNode n = this;
			StringBuilder sb = new StringBuilder();
			while(n != null){
				sb.append(n.value);
				n = n.next;
			}
			return sb.toString();
		}
	}

}
