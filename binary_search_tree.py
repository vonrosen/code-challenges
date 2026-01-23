from collections import deque

class TreeNode:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None

    def __str__(self):
        return f"Node({self.value})"

class BinarySearchTree:
    def __init__(self):
        self.root = None
        self.size = 0

    def insert(self, node_to_insert: TreeNode):
        if self.root is None:
            self.root = TreeNode(node_to_insert.value)
        else:
            self.__insert(self.root, node_to_insert)
        self.size += 1

    def __insert(self, current_node: TreeNode, node_to_insert: TreeNode):
        if current_node is None:
            return
        if node_to_insert.value > current_node.value:
            self.__insert(current_node.right, node_to_insert)
            if current_node.right is None:
                current_node.right = TreeNode(node_to_insert.value)
        if node_to_insert.value < current_node.value:
            self.__insert(current_node.left, node_to_insert)
            if current_node.left is None:
                current_node.left = TreeNode(node_to_insert.value)
        if node_to_insert.value == current_node.value:
            self.__insert(current_node.left, node_to_insert)
            if current_node.left is None:
                current_node.left = TreeNode(node_to_insert.value)
        return

    def find(self, node_to_find: TreeNode) -> TreeNode:
        return self.__find(self.root, node_to_find)

    def __find(self, current_node: TreeNode, node_to_find: TreeNode) -> TreeNode | None:
        if current_node is None:
            return None
        if node_to_find.value > current_node.value:
            return self.__find(current_node.right, node_to_find)
        if node_to_find.value < current_node.value:
            return self.__find(current_node.left, node_to_find)
        return current_node

    #todo - print a well formatted tree
    def bfs(self):
        if self.root is None:
            return
        queue = deque()
        queue.append(self.root)
        while len(queue) > 0:
            size = len(queue)
            for i in range(size):
                node = queue.popleft()
                print(node.value, end=" ")
                if node.left is not None:
                    queue.append(node.left)
                if node.right is not None:
                    queue.append(node.right)
            print("")


bst = BinarySearchTree()
bst.bfs()
bst.insert(TreeNode(7))
bst.insert(TreeNode(10))
bst.insert(TreeNode(9))
bst.insert(TreeNode(15))
bst.insert(TreeNode(5))
print(bst.find(TreeNode(0)))
print(bst.find(TreeNode(5)))
bst.insert(TreeNode(9))
bst.insert(TreeNode(9))
bst.bfs()
print(bst.find(TreeNode(9)))