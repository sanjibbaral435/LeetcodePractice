/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/*
When we delete a node, three possibilities arise.
1) Node to be deleted is leaf: Simply remove from the tree.
2) Node to be deleted has only one child: Copy the child to the node and delete the child
3) Node to be deleted has two children: Find inorder successor of the node. Copy contents of the inorder successor to the node and delete the inorder successor. Note that inorder predecessor can also be used.
*/
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return root;
        
        if(key > root.val)
            root.right = deleteNode(root.right, key);
        else if(key < root.val)
            root.left = deleteNode(root.left, key);
        else {
            if(root.left == null)
                return root.right;
            else if(root.right == null)
                return root.left;

            int min = findMin(root.right);
            root.val = min;
            
            root.right = deleteNode(root.right, min);
        }
        return root;
    }
    
    private int findMin(TreeNode node){
        while(node.left != null){
            node = node.left;
        }
        return node.val;
    }
}