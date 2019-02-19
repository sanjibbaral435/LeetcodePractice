/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Complexity O(h^2)

class Solution {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;

        int height = 0;
        TreeNode left = root.left, right = root.right;
        while(left != null && right != null) {
            height++; 
            left = left.left;
            right = right.right;
        }

        return left == right ? (1 << height + 1) - 1 : 1 + countNodes(root.left) + countNodes(root.right);
    } 
}