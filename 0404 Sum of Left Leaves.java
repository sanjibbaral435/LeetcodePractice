/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0;
        
        int left = 0;
        
        if(root.left != null && isLeafNode(root.left)) 
            left = root.left.val;
        
        return left + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
    
    private boolean isLeafNode(TreeNode root){
        return (root.left == null && root.right == null);
    }
}
