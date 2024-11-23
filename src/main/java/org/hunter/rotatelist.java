class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
 
class rotatelist {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null){
            return null;
        }
        int size = 0;
        ListNode current = head;
        while(current != null){
            current = current.next;
            ++size;
        }
        int kAdj = k % size;
        if(kAdj == 0){
            return head;
        }
        int find = size - kAdj;
        int index = 0;
        current = head;
        ListNode newHead = null;
        ListNode prev = null;
        while(current != null){
            if(index == find){
                newHead = current;
                prev.next = null;
            }
            prev = current;
            current = current.next;
            index++;
        }
        prev.next = head;
        return newHead;
    }
}
