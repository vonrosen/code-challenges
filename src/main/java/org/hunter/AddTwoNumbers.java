package org.hunter;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode n1 = l1;
        ListNode n2 = l2;
        ListNode newList = null;
        ListNode ans = null;
        int carry = 0;
        while(n1 != null || n2 != null) {
            int value;
            if(n1 != null && n2 != null) {
                value = n1.val + n2.val + carry;
                if(value > 9) {
                    carry = 1;
                    value = value % 10;
                }else {
                    carry = 0;
                }
            }else if(n1 != null) {
                value = n1.val + carry;
                if(value > 9) {
                    carry = 1;
                    value = value % 10;
                }else {
                    carry = 0;
                }
            }else {
                value = n2.val + carry;
                if(value > 9) {
                    carry = 1;
                    value = value % 10;
                }else {
                    carry = 0;
                }
            }
            if(newList == null) {
                newList = new ListNode(value);
                ans = newList;
            }else {
                newList.next = new ListNode(value);
                newList = newList.next;
            }
            n1 = n1 == null ? null : n1.next;
            n2 = n2 == null ? null : n2.next;
        }
        if(carry == 1) {
            newList.next = new ListNode(carry);
        }
        return ans;
    }
}
