# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def addOneRow(self, root, val, depth):
        if depth == 1:
            new_root = TreeNode(val)
            new_root.left = root
            return new_root

        def add_row(node, current_depth):
            if not node:
                return
            if current_depth == depth - 1:
                node.left = TreeNode(val, left=node.left)
                node.right = TreeNode(val, right=node.right)
            else:
                add_row(node.left, current_depth + 1)
                add_row(node.right, current_depth + 1)

        add_row(root, 1)
        return root
