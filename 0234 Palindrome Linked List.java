/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        if (fast != null) { // odd nodes: let right half smaller
            slow = slow.next;
        }
        slow = reverseList(slow);
        
        ListNode temp = head;
        while (slow != null) {
            if (temp.val != slow.val) {
                return false;
            }
            temp = temp.next;
            slow = slow.next;
        }
        return true;
        
    }
    
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;
        
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head;
    }
}
