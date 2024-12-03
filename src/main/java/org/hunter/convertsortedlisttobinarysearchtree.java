package org.hunter;

import org.hunter.ReverseLinkedList;
import org.hunter.ValidBst;
import org.hunter.ValidBst.TreeNode;

import java.util.*;

class ListNodex{
    int val;
    ListNodex next;
    ListNodex() {}
    ListNodex(int val) { this.val = val; }
    ListNodex(int val, ListNodex next) { this.val = val; this.next = next; }
}

class TreeNodex {
    int val;
    TreeNodex left;
    TreeNodex right;
    TreeNodex() {}
    TreeNodex(int val) { this.val = val; }
    TreeNodex(int val, TreeNodex left, TreeNodex right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


class convertsortedlisttobinarysearchtree {
    public TreeNodex sortedListToBST(ListNodex head) {
        if(head == null){
            return null;
        }
        int size = 0;
        ListNodex current = head;
        Map<Integer,ListNodex> map = new HashMap<>();
        while(current != null){
            map.put(size, current);
            size++;
            current = current.next;
        }
        return bst(map, 0, size - 1);
    }

    TreeNodex bst(Map<Integer,ListNodex> map, int start, int end){
        if(start == end){
            return new TreeNodex(map.get(start).val);
        }
        if(start == end - 1){
            ListNodex node = map.get(end);
            TreeNodex root = new TreeNodex(node.val);
            root.left = new TreeNodex(map.get(start).val);
            return root;
        }
        int mid = start + (end - start) / 2;
        TreeNodex root = new TreeNodex(map.get(mid).val);
        root.left = bst(map, start, mid - 1);
        root.right = bst(map, mid + 1, end);
        return root;
    }
}
