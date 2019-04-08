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
    boolean v1 = false;
    boolean v2 = false;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        TreeNode lca = LCAUtil(root, p, q);
        
        if(v1 && v2){
            return lca;
        } else {
            return null;
        }
    }
    
    public TreeNode LCAUtil(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        
        //Store result in temp, in case of key match so that we can search for other key also. 
        TreeNode temp = null;
        
        // If either n1 or n2 matches with root's key, report the presence 
        // by setting v1 or v2 as true and return root (Note that if a key 
        // is ancestor of other, then the ancestor key becomes LCA) 
        if(root.val == p.val){
            temp = root;
            v1 = true;
        }
        
        if(root.val == q.val){
            temp = root;
            v2 = true;
        }
        
        // Look for keys in left and right subtrees 
        TreeNode lca_left = LCAUtil(root.left, p, q);
        TreeNode lca_right = LCAUtil(root.right, p, q);
        
        
        if(temp != null) return temp;
        
        // If both of the above calls return Non-NULL, then one key 
        // is present in once subtree and other is present in other, 
        // So this node is the LCA 
        if (lca_left != null && lca_right != null) 
            return root; 
        
        return (lca_left != null)? lca_left : lca_right;
    }
        
}
