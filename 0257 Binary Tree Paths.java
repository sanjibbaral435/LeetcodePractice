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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>(); 
        binaryTreePathsUtil(root, res, "");
        return res;
    }
    
    public void binaryTreePathsUtil(TreeNode root, List<String> res, String curr){
        if(root == null) return;
        
        curr = curr + String.valueOf(root.val);
        
        if(isLeafNode(root)){
            res.add(curr);
        } else {
            curr = curr + "->";
            binaryTreePathsUtil(root.left, res, curr);
            binaryTreePathsUtil(root.right, res, curr);
        }
        
    }
    
    public boolean isLeafNode(TreeNode root){
        return (root.left == null && root.right == null);
    }
}
