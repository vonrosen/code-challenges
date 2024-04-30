package org.hunter;

public class RemoveNthNode{

	public static void main(String [] args){
		RemoveNthNode removeNthNode = new RemoveNthNode();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		System.out.println(removeNthNode.removeNthFromEnd(head, 2));
		head = new ListNode(1);
		System.out.println(removeNthNode.removeNthFromEnd(head, 1));
		head = new ListNode(1);
		head.next = new ListNode(2);
		System.out.println(removeNthNode.removeNthFromEnd(head, 1));
		head = new ListNode(1);
		head.next = new ListNode(2);
		System.out.println(removeNthNode.removeNthFromEnd(head, 2));
	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
		int size = 0;
		ListNode curr = head;
		while(curr != null){
			curr = curr.next;
			++size;
		}
		int nodeToDelete = size - n;
		if(nodeToDelete == 0){
			return head.next;
		}
		int i = 0;
		curr = head;
		ListNode prev = head;
		while(curr != null){
			if(i == nodeToDelete){
				prev.next = curr.next;
				break;
			}
			++i;
			prev = curr;
			curr = curr.next;
		}
		return head;
	}
}

class ListNode {
	int val;
	ListNode next;
	ListNode() {}
	ListNode(int val) { this.val = val; }
	ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}



