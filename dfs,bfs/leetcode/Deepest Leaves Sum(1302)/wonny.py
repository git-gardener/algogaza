# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def deepestLeavesSum(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        
        global deepestSum
        global maxDepth
        
        def getMaxDepth(root):
            if not root:
                return 0
            if not root.left and root.right:
                return 1
            
            left = getMaxDepth(root.left)
            right = getMaxDepth(root.right)
            
            return max(left,right)+1
        
        
        
        
        def getDeepestSum(root,depth):
            
            global deepestSum
            global maxDepth
            
            if not root:
                return
            
            if not root.left and not root.right:
                if depth == maxDepth:
                    deepestSum += root.val
                return
            
            getDeepestSum(root.left,depth+1)
            getDeepestSum(root.right,depth+1)
            return
        
        maxDepth = getMaxDepth(root)
        deepestSum = 0
        getDeepestSum(root,1)
 
        return deepestSum
