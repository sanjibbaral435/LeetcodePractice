/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/

// Create copy of node 1 between 1 and 2 and copy of 2 between 2 and 3 and so on.
// Time Complexity O(n)
// Space Complexity O(1)

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node temp = head;
        
        // insert additional node after every node of original list 
        while(temp!=null){
            Node temp1 = temp.next;
            temp.next = new Node(temp.val);
            temp.next.next = temp1;
            temp = temp1;
        }
        
        temp = head; 
        // adjust the random pointers of the newly added nodes  
        while(temp != null){
            if(temp.next != null){
                temp.next.random = (temp.random != null)?temp.random.next: temp.random;    
            }
            
            temp = (temp.next != null)? temp.next.next: temp.next;
        }
        
        temp = head;
        Node res = temp.next;
        Node temp2 = head.next;
        
        // now separate the original list and copied list
        while(temp != null && temp2 != null){
            temp.next = (temp.next != null)? temp.next.next: temp.next;
            
            temp2.next = (temp2.next != null)? temp2.next.next: temp2.next;
            
            temp2 = temp2.next;
            temp = temp.next;
        }
        
        return res;
    }
}
