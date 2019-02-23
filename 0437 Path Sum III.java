/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Basically do path sum from each node.
// Complexity O(n^2)
class Solution {
    public int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        return pathSumFrom(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    
    public int pathSumFrom(TreeNode root, int sum){
        if(root == null) return 0;
        
        return ((sum == root.val)?1:0) +
            pathSumFrom(root.left, sum - root.val) + pathSumFrom(root.right, sum - root.val);
    }
}
