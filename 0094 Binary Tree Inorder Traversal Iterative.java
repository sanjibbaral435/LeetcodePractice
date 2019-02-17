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
    
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<>();
        
        while(true){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            if(stack.isEmpty()) break;
            TreeNode node = stack.pop();
            res.add(node.val);
            root = node.right;
        }
        
        return res;
    }
}