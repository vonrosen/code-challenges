package org.hunter;

class MyLinkedList {

	private ListNode head;

	class ListNode{
		int val;
		ListNode next;

		ListNode(int val){
			this.val = val;
		}
	}

	public MyLinkedList() {

	}

	public int get(int index) {
		if(head == null){
			return -1;
		}
		int i = 0;
		ListNode next = head;
		while(next != null){
			if(i == index){
				return next.val;
			}
			++i;
			next = next.next;
		}

		return -1;
	}

	public void addAtHead(int val) {
		if(head == null){
			head = new ListNode(val);
			return;
		}

		ListNode newHead = new ListNode(val);
		newHead.next = head;
		head = newHead;
	}

	public void addAtTail(int val) {
		if(head == null){
			head = new ListNode(val);
			return;
		}

		ListNode next = head;
		ListNode prev = null;
		while(next != null){
			prev = next;
			next = next.next;
		}

		prev.next = new ListNode(val);
	}

	public void addAtIndex(int index, int val) {
		ListNode next = head;
		ListNode prev = null;
		int i = 0;
		while(next != null){
			if(i == index){
				if(prev == null){
					addAtHead(val);
					return;
				}else{
					ListNode tmp = new ListNode(val);
					prev.next = tmp;
					tmp.next = next;
					return;
				}
			}
			prev = next;
			++i;
			next = next.next;
		}
		if(i == index){
			if(prev == null){
				head = new ListNode(val);
			}else{
				prev.next = new ListNode(val);
			}
		}
	}

	public void deleteAtIndex(int index) {
		ListNode next = head;
		ListNode prev = null;
		int i = 0;
		while(next != null){
			if(i == index){
				if(prev == null){
					head = head.next;
					return;
				}else{
					prev.next = next.next;
					return;
				}
			}
			++i;
			prev = next;
			next = next.next;
		}

	}
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
