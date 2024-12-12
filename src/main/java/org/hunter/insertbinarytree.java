package org.hunter;

class insertbinarytree {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            return new TreeNode(val, null, null);
        }
        insert(root, val);
        return root;
    }

    void insert(TreeNode root, int val){                            
        if(val < root.val){
            if(root.left == null){
                root.left = new TreeNode(val, null, null);
                return;
            }
            insert(root.left, val);
            return;
        }
        if(root.right == null){
            root.right = new TreeNode(val, null, null);
            return;
        }
        insert(root.right, val);
    }
}
