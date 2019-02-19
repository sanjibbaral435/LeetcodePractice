/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    public Node connect(Node root) {
        Node temp = root;
        while(root != null){
            Node tempChild = new Node(0);
            Node currChild = tempChild;
            while(root != null){
                if(root.left != null){
                    currChild.next = root.left;
                    currChild = currChild.next;
                }
                if(root.right != null){
                    currChild.next = root.right;
                    currChild = currChild.next;
                }
                root = root.next;
            }
            root = tempChild.next;
        }
        
        return temp;
    }
}