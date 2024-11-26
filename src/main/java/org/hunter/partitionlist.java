class partitionlist {
    public ListNode partition(ListNode head, int x) {
        if(head == null){
            return null;
        }
        ListNode current = head;
        ListNode before = null;
        ListNode beforeHead = null;
        ListNode after = null;
        ListNode afterHead = null;
        ListNode mid = null;
        while(current != null){
            if(current.val < x){
                if(before == null){
                    before = current;
                    beforeHead = before;
                }else{
                    before.next = current;
                    before = before.next;
                }
            }else{
                if(after == null){
                    after = current;
                    afterHead = after;
                }else{
                    after.next = current;
                    after = after.next;
                }
            }
            current = current.next;
        }
        if(before != null){
            before.next = afterHead;
        }
        
        if(after != null){
            after.next = null;
        }
        if(beforeHead != null){
            return beforeHead;
        }
        return afterHead;
    }
}
