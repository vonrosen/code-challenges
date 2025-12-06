package org.hunter;

import java.util.ArrayList;
import java.util.List;

public class ReverseLinkedList{

	public static void main(String [] args){
		ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		System.out.println(reverseLinkedList.reverseList2(head));
	}

	//[1,2,3,4,5]
	//
	public ListNode reverseList2(ListNode head){
		ListNode curr = head;
		ListNode reversedHead = null;
		while(curr != null){
			ListNode nextTmp = curr.next;
			curr.next = reversedHead;
			reversedHead = curr;
			curr = nextTmp;
		}
		return reversedHead;
	}

	public ListNode reverseList(ListNode head) {
		if(head == null){
			return null;
		}
		ListNode reversed = new ListNode();
		List<ListNode> list = new ArrayList<>();
		ListNode next = head;
		while(next != null){
			list.add(next);
			next = next.next;
		}
		ListNode headReversed = reversed;
		for(int i = list.size() - 1; i >= 0; --i){
			reversed.val = list.get(i).val;
			if(i > 0){
				reversed.next = new ListNode(list.get(i - 1).val);
			}else{
				break;
			}
			reversed = reversed.next;
		}
		return headReversed;
	}

	public static class ListNode {
		public int val;
		public ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}

}
