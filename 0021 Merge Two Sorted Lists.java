/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) return l1;
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        
        ListNode result = new ListNode(0);
        ListNode prev = result;
        
        while(temp1 != null && temp2 != null){
            if(temp1.val <= temp2.val) {
                prev.next = temp1;
                temp1 = temp1.next;
            } else{
                prev.next = temp2;
                temp2 = temp2.next;
            }
            prev = prev.next; 
        }
        
        if(temp1 == null) {
            prev.next = temp2;
        }
        if(temp2 == null) {
            prev.next = temp1;
        }
        return result.next;
    }
}