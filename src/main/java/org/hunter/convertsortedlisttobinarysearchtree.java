import java.util.*;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class convertsortedlisttobinarysearchtree {
     public TreeNode sortedListToBST(ListNode head) {
        int size = 0;
        ListNode current = head;
        Map<Integer,ListNode> map = new HashMap<>();
        while(current != null){
            map.put(size, current);
            size++;
            current = current.next;
        }        
        return bst(map, 0, size - 1);
    }

    TreeNode bst(Map<Integer,TreeNode> map, int start, int end){
        if(start == end){
            return new TreeNode(node.val);
        }
        if(start == end - 1){
            ListNode node = map.get(end - 1);
            TreeNode root = new TreeNode(node.val);
            root.left = new TreeNode(map.get(start).val);
            return root;            
        }
        if(start == end - 2){
            ListNode node = map.get(start + 1);
            TreeNode root = new TreeNode(node.val);
            root.left = new TreeNode(map.get(start).val);
            root.right = new TreeNode(map.get(end).val);
            return root;
        }
        int mid = start + (end - start) / 2;
        TreeNode root = map.get(mid);
        if(root != null){
            TreeNode left = bst(map, start, mid - 1);
            TreeNode right = bst(map, mid + 1, end);
            root.left = left;
            root.right = right;
            return root;
        }
        return null;
    }
}
