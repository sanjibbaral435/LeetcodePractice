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
    int result = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0; // base case.
        if (root.val < low) return rangeSumBST(root.right, low, high); // left branch excluded.
        if (root.val > high) return rangeSumBST(root.left, low, high); // right branch excluded.
        return root.val
            + rangeSumBST(root.right, low, high)
            + rangeSumBST(root.left, low, high); // count in both children.
    }
}
