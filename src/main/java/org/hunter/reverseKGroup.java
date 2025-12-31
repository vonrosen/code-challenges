package org.hunter;

import java.util.*;

class reverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k == 1){
            return head;
        }
        ListNode prev = null;
        ListNode current = head;
        ListNode firstInGroup = head;
        int counter = 1;
        ListNode copyCurrent = null;
        List<ListNode> heads = new ArrayList<>();
        List<ListNode> tails = new ArrayList<>();
        while(current != null){
            copyCurrent = current;
            if(counter % k == 0){
                firstInGroup.next = null;
                tails.add(firstInGroup);
                heads.add(copyCurrent);
                firstInGroup = current.next;
            }            
            current = current.next; 
            copyCurrent.next = prev;
            prev = copyCurrent;        
            ++counter;
        }
        if((counter - 1) % k > 0){            
            current = copyCurrent;
            prev = null;
            firstInGroup.next = null;
            while(current != null){                
                copyCurrent = current;
                current = current.next;
                copyCurrent.next = prev;
                prev = copyCurrent;
            }            
            heads.add(copyCurrent);
        }
        for(int i = 0; i < tails.size(); ++i){
            if(i + 1 <= heads.size() - 1){
                tails.get(i).next = heads.get(i + 1);
            }
        }
        return heads.get(0);
    }
    
}
