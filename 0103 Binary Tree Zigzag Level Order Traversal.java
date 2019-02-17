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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        
        zigzagLevelOrderUtil(root, res, 0);
        return res;
        
    }
    
    public void zigzagLevelOrderUtil(TreeNode root, List<List<Integer>> res, int level){
        if(root == null) return;
        
        if(res.size() == level)
            res.add(new ArrayList<Integer>());
        if(level%2 == 0)
            res.get(level).add(root.val);
        else
            res.get(level).add(0, root.val);
        
        zigzagLevelOrderUtil(root.left, res, level+1);
        zigzagLevelOrderUtil(root.right, res, level+1);
    }
}