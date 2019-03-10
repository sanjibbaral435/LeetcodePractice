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
    public boolean isUnivalTree(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) return true;
        
        boolean left = true;
        boolean right = true;
        if(root.left != null && root.val != root.left.val)
            left = false;
        
        if(root.right != null && root.val != root.right.val)
            right = false;

        return left && right && isUnivalTree(root.left) && isUnivalTree(root.right);
    }
}
