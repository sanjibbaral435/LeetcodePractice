/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next == null) return head;
        
        int count = 0;
        ListNode temp = head;
    
        // count length of the List
        while(temp != null){
            temp = temp.next;
            count++;
        }
        
        // actutal number of rotation needed
        k = k%count;
        
        ListNode first = head;
        ListNode second = head;
        // create a gap of k
        while(k > 0){
            second = second.next;
            k--;
        }
        
        //traverse both till second is in last node
        while(second.next != null){
            first = first.next;
            second = second.next;
        }
        
        //now manipulate to point the head to first.next and etc.
        second.next = head;
        head = first.next;
        first.next = null;
        
        return head;
    }
}