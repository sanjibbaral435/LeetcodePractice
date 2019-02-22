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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> curr = new ArrayList<Integer>();
        
        pathSumUtil(root, sum, res, curr);
        
        return res;
    }
    
    public void pathSumUtil(TreeNode root, int sum, List<List<Integer>> res, List<Integer> curr){
        if(root == null) return;
        
        curr.add(root.val);
        
        if(root.val == sum && isLeafNode(root)){
            res.add(new ArrayList(curr));
            curr.remove(curr.size() - 1);
            return;
        }
        else{
            pathSumUtil(root.left, sum - root.val, res, curr);
            pathSumUtil(root.right, sum - root.val, res, curr);
        }
        curr.remove(curr.size() - 1);
    }
    
    public boolean isLeafNode(TreeNode root){
        return (root.left == null && root.right == null);
    }
}	
