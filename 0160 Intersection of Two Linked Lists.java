/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        
        int len1 = 0;
        int len2 = 0;
        
        ListNode temp = headA;
        while(temp != null){
            len1++;
            temp = temp.next;
        }
        
        temp = headB;
        while(temp != null){
            len2++;
            temp = temp.next;
        }
        
        if(len1 < len2){
            int diff  = len2 - len1;
            while(diff > 0){
                headB = headB.next;
                diff--;
            }
        } else {
            int diff  = len1 - len2;
            while(diff > 0){
                headA = headA.next;
                diff--;
            }
        }
        
        while(headA != null){
            if(headA == headB) return headA;
            headA = headA.next;
            headB = headB.next;
        }
        
        return null;
    }
}
