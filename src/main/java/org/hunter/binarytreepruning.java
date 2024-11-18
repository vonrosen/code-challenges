
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
 
class binarytreepruning {
    public TreeNode pruneTree(TreeNode root) {
        pruneTree2(root);
        if(root.left == null && root.right == null && root.val != 1){
            root = null;
        }
        return root;        
    }

    boolean pruneTree2(TreeNode node){
        if(node == null){
            return true;
        }
        boolean left = pruneTree2(node.left);
        boolean right = pruneTree2(node.right);
        if(left){
            node.left = null;
        }
        if(right){
            node.right = null;
        }
        if(left && right && node.val != 1){
            return true;
        }
        return false;
    }
}
