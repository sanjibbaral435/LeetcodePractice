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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> path1 = new ArrayList<>();
        List<TreeNode> path2 = new ArrayList<>();
        
        boolean v1 = findPath(root, p.val, path1);
        boolean v2 = findPath(root, q.val, path2);
        
        if(v1 && v2){
            int i; 
            for (i = 0; i < path1.size() && i < path2.size(); i++) { 
                if (!path1.get(i).equals(path2.get(i))) 
                    break; 
            } 
            return path1.get(i-1);
        } else {
            // atleast one value is not present
            return null;
        }
    }
    
    public boolean findPath(TreeNode root, int n, List<TreeNode> path){
        if(root == null) return false;
        
        path.add(root);
        
        if(root.val == n) return true;
        
        if(root.left != null && findPath(root.left, n, path)) return true;
        
        if(root.right != null && findPath(root.right, n, path)) return true;
        
        path.remove(path.size() - 1);
        
        return false;
    }
}
