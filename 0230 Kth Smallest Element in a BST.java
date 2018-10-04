/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Apporach is to run inorder traversal k times
class Solution {
    int c = 0;
    int kSmallest = Integer.MAX_VALUE;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return kSmallest;
    }
    
    public void inorder(TreeNode root, int k){
        if(root == null) return;
        kthSmallest(root.left, k);
        c++;
        if(c == k){
            kSmallest = root.val;
        }
        kthSmallest(root.right, k);
    }
    
}