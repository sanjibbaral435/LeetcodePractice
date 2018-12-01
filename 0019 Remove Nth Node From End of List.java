/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return head;
        ListNode first = head;
        ListNode second = head;
        while(n>0) {
            second = second.next;
            n--;
        }
        
        if(second == null){
            //head node to be removed
            head = head.next;
            return head;
        }
        
        while(second.next != null){
            first = first.next;
            second = second.next;
        }
        
        first.next = first.next.next;
        
        return head;
        
    }
}