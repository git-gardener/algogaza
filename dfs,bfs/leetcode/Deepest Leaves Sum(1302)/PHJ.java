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
class Solution {
    int[] numbers = new int[100000];
    
    public int deepestLeavesSum(TreeNode root) {
        if(root == null){
            return 0;
        }
        
        for(int i=0;i<numbers.length;i++){
            numbers[i] = 0;
        }
        
        dfs(root, 0);
        
        int result = 0;
        for(int i=0;i<numbers.length;i++){
            if(numbers[i] != 0){
                result = numbers[i];
            }
        }
        
        return result;
    }
    
    public void dfs(TreeNode root, int depth){
        if(root != null){
            numbers[depth] += root.val;
        }
        
        if(root.left != null){
            dfs(root.left, depth+1);    
        }
        
        if(root.right != null){
            dfs(root.right, depth+1);
        }
    }
}
