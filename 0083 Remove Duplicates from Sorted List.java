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
        ListNode temp = head;
        ListNode prev = head;
        while(temp != null){
            while(temp != null && temp.val == prev.val) temp = temp.next;
            if(temp == null) {
                prev.next = null;
                return head;
            }
            prev.next = temp;
            prev = temp;
            temp = temp.next;
        }
        return head;
    }
}