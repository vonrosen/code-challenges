class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

/**
 *  Input: head = [1,2,3,3,4,4,5]
    Output: [1,2,5]
 */
class removeduplicatesfromsortedlistii {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode next = head.next;
        ListNode node = delete(head);
        if(node != null && next != null && node.val == next.val){
            return node.next;
        }
        return node;
    }
    
    public ListNode delete(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode next = deleteDuplicates(head.next);
        if(next == null){
            head.next = null;
        }else{
            if(next.val == head.val){
                return next.next;
            }
            head.next = next;
        }
        return head;
    }
   
}
