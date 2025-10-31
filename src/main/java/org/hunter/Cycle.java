package org.hunter;

public class Cycle {

    public boolean hasCycle(ListNode head) {
        ListNode next = head;
        ListNode nextNext = head != null && head.next != null ? head.next.next : null;
        while(nextNext != null) {
            if (next == nextNext) {
                return true;
            }
            nextNext = nextNext != null && nextNext.next != null ? nextNext.next.next : null;
            next = next.next;
        }
        return false;
    }
}
