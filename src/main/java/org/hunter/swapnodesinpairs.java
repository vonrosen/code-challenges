
class swapnodesinpairs {
    public ListNode swapPairs(ListNode head) {
        return swap(head, head == null ? null : head.next);
    }

    ListNode swap(ListNode first, ListNode second){
        if(first == null){
            return null;
        }
        if(second == null){
            return first;
        }
        first.next = swap(second.next, second.next == null ? null : second.next.next);
        second.next = first;
        return second;
    }
}
