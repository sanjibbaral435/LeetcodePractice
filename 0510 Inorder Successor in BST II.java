/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/
class Solution {
    public Node inorderSuccessor(Node x) {
        // It will be either in right child or in the parent chain
        if(x.right == null){
            // in the parent chain
            Node result = x.parent;
            while (result != null && result.val < x.val) {
                result = result.parent;
            }
            return result;
        } else {
            // in the right subtree
            Node result = x.right;
            while (result.left != null) {
                result = result.left;
            }
            return result;
        }
    }
}