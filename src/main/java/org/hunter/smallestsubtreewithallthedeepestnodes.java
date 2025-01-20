package.org.hunter;

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
class smallestsubtreewithallthedeepestnodes {

    TreeNode ans;
    int max = 0;

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        subtreeWithAllDeepest(root, 0);
        return ans;
    }

    int subtreeWithAllDeepest(TreeNode node, int index){
        if(node == null){
            return index;
        }

        int left = subtreeWithAllDeepest(node.left, index + 1);
        int right = subtreeWithAllDeepest(node.right, index + 1);

        if(left == right){
            if(max <= left){
                ans = node;
                max = left;
            }
            return left;
        }else if(left > right){
            return left;
        }else{
            return right;
        }
    }
}
