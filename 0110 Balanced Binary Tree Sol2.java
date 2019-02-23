/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Instead of doing the depth for each node, we can do in one go, check the both height difference, if its differ more than 1 return -1 (which will mean that the subtree is not balanced.) else if its balanced then return the height
// Complexity O(n)
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        return (height(root) != -1);
    }
    
    public int height(TreeNode root){
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        
        int lheight = height(root.left);
        if(lheight == -1) return -1;
        
        int rheight = height(root.right);
        if(rheight == -1) return -1;
        
        if(Math.abs(lheight - rheight) > 1) return -1;
        else return ((lheight > rheight)?lheight : rheight)+1;
    }
}
