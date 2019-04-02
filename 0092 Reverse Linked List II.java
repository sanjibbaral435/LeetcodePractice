/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        int diffNodes = n-m;
        
        if(diffNodes < 1) return head;
        ListNode prev = new ListNode(-1);
        ListNode temp = head;
        
        while(m > 1){
            prev = temp;
            temp = temp.next;
            m--;
        }
        
        prev.next = reverseList(temp, diffNodes+1);
        
        return (prev.val == -1)? prev.next: head;
    }
    
    public ListNode reverseList(ListNode root, int diff){
        ListNode prev = null;
        ListNode curr = root;
        while(curr != null && diff > 0){
            ListNode tempNext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tempNext;
            diff--;
        }
        
        root.next = curr;
        return prev;
    }
}
