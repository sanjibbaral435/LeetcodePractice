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
    int res = 0;
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        sumNumbersUtil(root, 0);
        return res;
    }
    
    public void sumNumbersUtil(TreeNode root, int curr){
        if(root.left == null && root.right == null){
            curr = curr*10 + root.val;
            res = res + curr;
            return;
        }
        
        curr = curr*10+root.val;
        
        if(root.left != null) sumNumbersUtil(root.left, curr);
        if(root.right != null) sumNumbersUtil(root.right, curr);
    }
}
