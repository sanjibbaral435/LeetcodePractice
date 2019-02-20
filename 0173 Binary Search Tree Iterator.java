/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BSTIterator {
    
    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<TreeNode>();
        if(root != null) {
            stack.push(root);
            TreeNode curr = root.left;
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }
        }
    }
    
    /** @return the next smallest number */
    public int next() {
        TreeNode node = null;
        if(!stack.isEmpty()){
            node = stack.pop();
        }
        int val = (node == null)? Integer.MAX_VALUE: node.val;
        if(node.right != null){
            stack.push(node.right);
            TreeNode curr = node.right.left;
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }
        }
        return val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */