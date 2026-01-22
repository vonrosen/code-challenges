# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    ans = 0
    def goodNodes(self, root: TreeNode) -> int:
        def goodNodes(root, maxValue):
            if root is None:
                return

            if root.val >= maxValue:
                self.ans += 1

            goodNodes(root.left, max(root.val, maxValue))
            goodNodes(root.right, max(root.val, maxValue))

        goodNodes(root, root.val)
        return self.ans
