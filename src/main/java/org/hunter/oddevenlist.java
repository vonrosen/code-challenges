class oddevenlist {
    
    public ListNode oddEvenList(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode oddHead = head;
        ListNode evenHead = head.next;
        ListNode evenCurrent = evenHead;
        while(head != null && evenCurrent != null && head.next != null && evenCurrent.next != null){
            head.next = head.next.next;
            evenCurrent.next = evenCurrent.next.next;
            evenCurrent = evenCurrent.next;
            head = head.next;            
        }        
        head.next = evenHead;
        return oddHead;
    }
}
