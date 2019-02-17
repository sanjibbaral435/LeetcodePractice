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
    int min = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        minDepthUtil(root, 0);
        return (min == Integer.MAX_VALUE)? 0 : min;
    }
    
    public void minDepthUtil(TreeNode root, int level) {
        if(root == null) return;
        
        if(root.left == null && root.right == null){
            if(level + 1 < min) min = level + 1;
        }
        minDepthUtil(root.left, level+1);
        minDepthUtil(root.right, level+1);
    }
}