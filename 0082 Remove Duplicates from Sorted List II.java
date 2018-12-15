/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode FakeHead=new ListNode(0);
        FakeHead.next=head;
        ListNode prev=FakeHead;
        
        ListNode temp = head;
        
        while(temp != null && temp.next != null){
            if(temp.val != temp.next.val){
                prev = temp;
                temp = temp.next;
                continue;
            } else {
                ListNode temp1 = temp;
                while(temp1.next != null && temp1.val == temp1.next.val) temp1 = temp1.next;
                prev.next = temp1.next;
                temp = temp1.next;
            }
        }
        return FakeHead.next;
    }
}