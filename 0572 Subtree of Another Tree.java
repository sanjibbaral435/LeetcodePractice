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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null) return false;
        else {
            return isEqual(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
        }
    }
    
    public boolean isEqual(TreeNode x, TreeNode y){
        if(x==null && y==null)
            return true;
        if(x==null || y==null)
            return false;
        return x.val==y.val && isEqual(x.left,y.left) && isEqual(x.right,y.right);
    }
}
