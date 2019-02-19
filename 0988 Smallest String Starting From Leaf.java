/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Idea: do a post order traversal and keep adding lexicographically small strings among the left and right chind
class Solution {
    public String smallestFromLeaf(TreeNode root) {
        if(root == null) return "";
        else {
            String left = smallestFromLeaf(root.left);
            String right = smallestFromLeaf(root.right);
            
            if(left.length() > 0 && right.length() > 0){
                return (( (left.compareTo(right) < 0) ? left: right) + (char)(root.val+'a'));
            } else if(left.length() > 0){
                return left + (char)(root.val+'a');                
            } else {
                return right + (char)(root.val+'a');
            }
        }
    }
}