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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        
        levelOrderBottomUtil(root, res, 0);
        return res;
        
    }
    
    public void levelOrderBottomUtil(TreeNode root, List<List<Integer>> res, int level){
        if(root == null) return;
        if(res.size() == level)
            res.add(0, new ArrayList<Integer>());
        
        res.get(res.size()-level-1).add(root.val);
        
        levelOrderBottomUtil(root.left, res, level+1);
        levelOrderBottomUtil(root.right, res, level+1);
    }
}