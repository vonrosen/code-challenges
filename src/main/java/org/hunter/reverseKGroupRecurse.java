package org.hunter;

class reverseKGroupRecurse {
    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode current = head;
        ListNode copy = head;
        while(current != null){
            if(count == k){                
                break;
            }
            copy = current;
            current = current.next;
            count++;
        }
        if(count < k){
            return head;
        }
        ListNode nextHead = reverseKGroup(copy.next, k);
        current = head;
        ListNode prev = null;
        count = 0;
        while(current != null){
            if(count == k){
                break;
            }            
            copy = current;
            current = current.next;
            copy.next = prev;
            prev = copy;
            ++count;
        }
        head.next = nextHead;
        return copy;
    }
    
}
