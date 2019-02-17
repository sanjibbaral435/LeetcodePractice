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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        
        largestValuesUtil(root, res, 0);
        return res;
        
    }
    
    public void largestValuesUtil(TreeNode root, List<Integer> res, int level){
        if(root == null) return;
        
        if(res.size() == level)
            res.add(root.val);
        else if(res.get(level) < root.val)
            res.set(level, root.val);
        
        
        largestValuesUtil(root.left, res, level+1);
        largestValuesUtil(root.right, res, level+1);
    }
}