/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
};
*/
class Solution {
    public Node flatten(Node head) {
        if(head == null) return null;
        Node temp = head;
        Node next = temp.next;
        
        while(temp != null){
            if(temp.child != null){
                Node tempChild = temp.child;
                
                temp.next = tempChild;
                tempChild.prev = temp;
                temp.child = null;
                
                while(tempChild.next != null){
                    tempChild = tempChild.next;
                }
                
                tempChild.next = next;
                
                if(next != null) next.prev = tempChild;
            }
            
            temp = temp.next;
            if(temp != null) next = temp.next;
        }
        
        return head;
    }
}
