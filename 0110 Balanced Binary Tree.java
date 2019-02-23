/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Check the depth of left and right subtree and see if balanced and recursively do this for all
// Complexity O(n^2)
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        if(root.left == null && root.right == null) return true;
        int lheight = height(root.left);
        int rheight = height(root.right);
        
        return (Math.abs(lheight - rheight) < 2) && isBalanced(root.left) && isBalanced(root.right);
    }
    
    public int height(TreeNode root){
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        int lheight = height(root.left);
        int rheight = height(root.right);
        
        return ((lheight > rheight)?lheight : rheight)+1;
    }
}
