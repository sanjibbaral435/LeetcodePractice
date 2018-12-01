/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode prev = head;
        ListNode curr = head.next;
        head = curr;
        
        // Traverse the list 
        while (true) 
        { 
            ListNode future = curr.next; 
            
            // Change next of current as previous node 
            curr.next = prev; 
            
            // If future null or future is the last node 
            if (future == null || future.next == null) 
            { 
                prev.next = future; 
                break; 
            } 

            // Change next of previous to next future 
            prev.next = future.next; 

            // Update previous and curr 
            prev = future; 
            curr = prev.next; 
        } 
        
        return head;
    }
}