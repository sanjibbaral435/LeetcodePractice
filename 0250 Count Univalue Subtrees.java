/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// 

class Solution {
    int count = 0;
    
    public int countUnivalSubtrees(TreeNode root) {
        if(root == null) return 0;
        isUnivalTree(root);
        return count;
    }
    
    public boolean isUnivalTree(TreeNode root) {
        if(root.left == null && root.right == null){
            count++;
            return true;
        }         
        
        boolean isUnival = true;
        if(root.left != null)
            isUnival = isUnivalTree(root.left) && isUnival && (root.val == root.left.val);
        
        if(root.right != null)
            isUnival = isUnivalTree(root.right) && isUnival && (root.val == root.right.val);

        if(isUnival){
            count++;
            return true;
        }
        else return false;
    }
}
