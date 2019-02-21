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
    public void flatten(TreeNode root) {
        TreeNode curr = root;
        
        while(curr != null){
            if(curr.left != null){
                TreeNode left = curr.left;
                TreeNode right = curr.right;

                curr.right = left;
                while(left.right != null){
                    left = left.right;
                }
                left.right = right;
                curr.left = null;
            }
            curr = curr.right;
        }
    }
}