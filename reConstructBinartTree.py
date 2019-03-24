#coding:utf-8
import os
from idlelib.TreeWidget import TreeNode

os.environ["TF_CPP_MIN_LOG_LEVEL"] = "3"


# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
class Solution:
    # 返回构造的TreeNode根节点
    def reConstructBinaryTree(self, pre, tin):

        if len(pre)<1:
            return None

        root=TreeNode(pre[0])
        index=tin.index(root.val)

        root.left=self.reConstructBinaryTree(pre[1:1+index],pre[:index])
        root.right=self.reConstructBinaryTree(tin[1+index:],tin[index+1:])
