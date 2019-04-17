/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode oddHead = head;
        ListNode evenHead = head.next;
        
        ListNode temp1 = oddHead;
        ListNode temp2 = evenHead;
        ListNode oddTail = oddHead;
        
        while(temp1 != null && temp2 != null){
            oddTail = temp1;
            
            temp1.next = temp2.next;
            temp1 = temp2.next;
            
            if(temp1 != null){
                temp2.next = temp1.next;
                temp2 = temp1.next;
            }
        }
        
        if(oddTail.next == null)
            oddTail.next = evenHead;
        else 
            oddTail.next.next = evenHead;
        
        return oddHead;
    }
}
