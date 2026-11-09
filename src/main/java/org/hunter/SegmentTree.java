package org.hunter;

public class SegmentTree {

    SegmentTreeNode root;

    SegmentTree(SegmentTreeNode root) {
        this.root = root;
    }

    static class SegmentTreeNode {
        int sum;
        int left;
        int right;
        SegmentTreeNode leftNode;
        SegmentTreeNode rightNode;

        SegmentTreeNode(int left, int right,  SegmentTreeNode leftNode, SegmentTreeNode rightNode, int sum) {
            this.left = left;
            this.right = right;
            this.leftNode = leftNode;
            this.rightNode = rightNode;
            this.sum = sum;
        }
    }

    public static void main(String [] args) {
        var tree = new SegmentTree(
                SegmentTree.build(new int [] {
                        5,2,4,55,-45,3
                })
        );
        System.out.println(tree.sum(0, 0));
        System.out.println(tree.sum(1, 1));
        System.out.println(tree.sum(2, 2));
        System.out.println(tree.sum(3, 3));
        System.out.println(tree.sum(4, 4));
        System.out.println(tree.sum(5, 5));

        System.out.println(tree.sum(0, 5));
        System.out.println(tree.sum(0, 2));
        System.out.println(tree.sum(1, 3));
        System.out.println(tree.sum(1, 5));
        System.out.println(tree.sum(4, 5));
    }

    public int sum(int left, int right) {
        if (root == null) {
            return 0;
        }
        return sum(left, right, root);
    }

    private int sum(int left, int right, SegmentTreeNode node) {
        if(node.left == left && node.right == right) {
            return node.sum;
        }
        if(node.leftNode == null || node.rightNode == null) {
            return 0;
        }
        int mid = node.left + (node.right - node.left) / 2;
        if (left <= mid && right <= mid) {
            return sum(left, right, node.leftNode);
        }
        if(left > mid && right > mid) {
            return sum(left, right, node.rightNode);
        }
        int leftSum = sum(left, mid, node.leftNode);
        int rightSum = sum(mid + 1, right, node.rightNode);
        return leftSum + rightSum;
    }


    static SegmentTreeNode build(int [] nums) {
        return build(nums, 0, nums.length - 1);
    }

    private static SegmentTreeNode build(int [] nums, int left, int right) {
        if (left == right) {
            return new SegmentTreeNode(left, right, null, null, nums[left]);
        }
        int mid = left + (right - left) / 2;
        var nodeLeft = build(nums, left, mid);
        var nodeRight = build(nums, mid + 1, right);
        return merge(nodeLeft, nodeRight);
    }

    private static SegmentTreeNode merge(SegmentTreeNode nodeLeft, SegmentTreeNode nodeRight) {
        return new SegmentTreeNode(nodeLeft.left, nodeRight.right, nodeLeft, nodeRight, nodeLeft.sum + nodeRight.sum);
    }
}
