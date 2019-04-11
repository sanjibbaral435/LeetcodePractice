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
    int[] postorder;
    int[] inorder;
    int post_index;

    Map<Integer, Integer> inorder_index = new HashMap<>();
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        this.inorder = inorder;
        post_index = postorder.length-1;
        
        for(int i=0; i<inorder.length; i++){
            inorder_index.put(inorder[i], i);
        }
        
        return buildTreeUtil(0, inorder.length);
    }
    
    public TreeNode buildTreeUtil(int start, int end){
        if(start == end)
            return null;
        
        // Get the root node val from the preorder
        int root_val = postorder[post_index--];
        
        // Get the index of this root, in the inorder sequence
        int index = inorder_index.get(root_val);
        
        
        TreeNode root = new TreeNode(root_val);
        
        root.right = buildTreeUtil(index+1, end);
        root.left = buildTreeUtil(start, index);
        
        
        return root;
        
    }
}
