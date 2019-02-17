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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        
        levelOrderUtil(root, res, 0);
        return res;
        
    }
    
    public void levelOrderUtil(TreeNode root, List<List<Integer>> res, int level){
        if(root == null) return;
        
        if(res.size() == level)
            res.add(new ArrayList<Integer>());
        
        res.get(level).add(root.val);
        levelOrderUtil(root.left, res, level+1);
        levelOrderUtil(root.right, res, level+1);
    }
}