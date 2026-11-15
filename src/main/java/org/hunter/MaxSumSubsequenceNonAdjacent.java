package org.hunter;

public class MaxSumSubsequenceNonAdjacent {

    //O(Q * 2^N) without memoization
    //O(Q * N^2) with memoization
//    public int maximumSumSubsequence2(int[] nums, int[][] queries) {
//        int ans = 0;
//        for (int [] query : queries) {
//            nums[query[0]] = query[1];
//            int thisAns = 0;
//            Integer [] mem = new Integer[nums.length];
//            for (int i = 0; i < nums.length; ++i) {
//                thisAns = Math.max(thisAns, maximumSumSubsequence(nums, i, mem));
//            }
//            ans += thisAns;
//        }
//        return ans;
//    }
//
//    public int maximumSumSubsequence(int[] nums, int index, Integer[] mem) {
//        if (index > nums.length - 1) {
//            return 0;
//        }
//        if (mem[index] != null) {
//            return mem[index];
//        }
//        int ans = nums[index];
//        for (int i = index + 2; i < nums.length; ++i) {
//            ans = Math.max(ans, nums[index] + maximumSumSubsequence(nums, i, mem));
//        }
//        mem[index] = ans;
//        return ans;
//    }

    public static void main(String [] args) {
        MaxSumSubsequenceNonAdjacent m = new MaxSumSubsequenceNonAdjacent();
//        System.out.println(m.maximumSumSubsequence(
//                new int [] {
//                        3,5,9
//                },
//                new int [][] {
//                        {1,-2},
//                        {0,-3}
//                }));
        System.out.println(m.maximumSumSubsequence(
                new int [] {
                        0,3,3,3,1,-2
                },
                new int [][] {
                        {4,0},
                        {1,0}
                }));
//        System.out.println(m.maximumSumSubsequence(
//                new int [] {
//                        6
//                },
//                new int [][] {
//                        {0,-2},
//                }));

//ut.println(m.maximumSumSubsequence(
//                new int [] {
//                        1,0,2
//                },
//                new int [][] {
//                        {1,10},
//                }));

    }

    public int maximumSumSubsequence(int[] nums, int[][] queries) {
        long ans = 0;
        var tree = new MaxSumSegmentTree(
                MaxSumSegmentTree.build(nums)
        );
        for (int [] query : queries) {
            tree.update(tree.root, query[0], query[1]);
            ans += Math.max(tree.query(0, nums.length - 1), 0);
        }
        if (ans < 0) {
            return 0;
        }
        return (int)(ans % (1_000_000_000L + 7L));
    }

    static class MaxSumSegmentTree {

        MaxSumSegmentTreeNode root;

        MaxSumSegmentTree(MaxSumSegmentTreeNode root) {
            this.root = root;
        }

        static class MaxSumSegmentTreeNode {
            long left;
            long right;
            long leftButNotRight;
            long leftAndRight;
            long rightButNotLeft;
            long none;
            MaxSumSegmentTreeNode leftNode;
            MaxSumSegmentTreeNode rightNode;

            MaxSumSegmentTreeNode(long left,
                                  long right,
                                  long leftButNotRight,
                                  long rightButNotLeft,
                                  long leftAndRight,
                                  long none,
                                  MaxSumSegmentTreeNode leftNode,
                                  MaxSumSegmentTreeNode rightNode) {
                this.left = left;
                this.right = right;
                this.leftButNotRight = leftButNotRight;
                this.rightButNotLeft = rightButNotLeft;
                this.leftAndRight = leftAndRight;
                this.none = none;
                this.leftNode = leftNode;
                this.rightNode = rightNode;
            }

            public long max() {
                return Math.max(Math.max(leftButNotRight, rightButNotLeft), Math.max(leftAndRight, none));
            }

            public void update(long value) {
                leftButNotRight = rightButNotLeft = leftAndRight = none = value;
            }

            public void update(MaxSumSegmentTreeNode node) {
                leftButNotRight = node.leftButNotRight;
                rightButNotLeft = node.rightButNotLeft;
                leftAndRight = node.leftAndRight;
                none = node.none;
            }

            public void reMerge() {
                var node = MaxSumSegmentTree.merge(leftNode, rightNode);
                update(node);
            }
        }

        public void update(MaxSumSegmentTreeNode node, int index, int value) {
            if (node.left == index && node.right == index) {
                node.update(value);
                return;
            }
            long mid = node.left + (node.right - node.left) / 2;
            if (index <= mid) {
                update(node.leftNode, index, value);
                node.reMerge();
                return;
            }
            update(node.rightNode, index, value);
            node.reMerge();
        }

        public long query(int left, int right) {
            if (root == null) {
                return 0;
            }
            return query(left, right, root);
        }

        private long query(long left, long right, MaxSumSegmentTreeNode node) {
            if(node.left == left && node.right == right) {
                return node.max();
            }
            if(node.leftNode == null || node.rightNode == null) {
                return node.max();
            }
            long mid = node.left + (node.right - node.left) / 2;
            if (left <= mid && right <= mid) {
                return query(left, right, node.leftNode);
            }
            if(left > mid && right > mid) {
                return query(left, right, node.rightNode);
            }
            long leftSum = query(left, mid, node.leftNode);
            long rightSum = query(mid + 1, right, node.rightNode);
            return leftSum + rightSum;
        }


        static MaxSumSegmentTreeNode build(int [] nums) {
            return build(nums, 0, nums.length - 1);
        }

        private static MaxSumSegmentTreeNode build(int [] nums, int left, int right) {
            if (left == right) {
                return new MaxSumSegmentTreeNode(
                        left,
                        right,
                        nums[left],
                        nums[left],
                        nums[left],
                        nums[left],
                        null,
                        null);
            }
            int mid = left + (right - left) / 2;
            var nodeLeft = build(nums, left, mid);
            var nodeRight = build(nums, mid + 1, right);
            return merge(nodeLeft, nodeRight);
        }

        public static MaxSumSegmentTreeNode merge(MaxSumSegmentTreeNode nodeLeft, MaxSumSegmentTreeNode nodeRight) {
            if(nodeLeft.leftNode == null && nodeRight.leftNode == null) { //merge 2 leaf nodes
                return new MaxSumSegmentTreeNode(
                        nodeLeft.left,
                        nodeRight.right,
                        nodeLeft.leftButNotRight,
                        nodeRight.rightButNotLeft,
                        0,
                        0,
                        nodeLeft,
                        nodeRight);
            }
            if (nodeLeft.leftNode == null) {
                return new MaxSumSegmentTreeNode(
                        nodeLeft.left,
                        nodeRight.right,
                        nodeLeft.leftButNotRight,
                        nodeRight.rightButNotLeft,
                        nodeLeft.leftButNotRight + nodeRight.rightButNotLeft,
                        Math.max(nodeRight.none, nodeRight.leftButNotRight),
                        nodeLeft,
                        nodeRight);
            }
            if (nodeRight.leftNode == null) {
                return new MaxSumSegmentTreeNode(
                        nodeLeft.left,
                        nodeRight.right,
                        nodeLeft.leftButNotRight,
                        nodeRight.rightButNotLeft,
                        nodeLeft.leftButNotRight + nodeRight.rightButNotLeft,
                        Math.max(nodeLeft.rightButNotLeft, nodeLeft.none),
                        nodeLeft,
                        nodeRight);
            }
            return new MaxSumSegmentTreeNode(
                    nodeLeft.left,
                    nodeRight.right,
                    Math.max(Math.max(nodeLeft.leftButNotRight + nodeRight.leftButNotRight, nodeLeft.leftButNotRight + nodeRight.none), nodeLeft.leftAndRight + nodeRight.none),
                    Math.max(Math.max(nodeLeft.rightButNotLeft + nodeRight.rightButNotLeft, nodeLeft.none + nodeRight.rightButNotLeft), nodeLeft.none + nodeRight.leftAndRight),
                    Math.max(Math.max(nodeLeft.leftButNotRight + nodeRight.rightButNotLeft, nodeLeft.leftButNotRight + nodeRight.leftAndRight), nodeLeft.leftAndRight + nodeRight.rightButNotLeft),
                    Math.max(Math.max(nodeLeft.none + nodeRight.none, nodeLeft.rightButNotLeft + nodeRight.none), nodeLeft.none + nodeRight.leftButNotRight),
                    nodeLeft,
                    nodeRight);
        }

    }

}
