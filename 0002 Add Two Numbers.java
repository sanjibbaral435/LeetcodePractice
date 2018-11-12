/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        int carry = 0;
        int newValue = (l1.val+l2.val)%10;
        ListNode current = new ListNode(newValue);
            
        carry = (l1.val+l2.val)/10;
            
        l1 = l1.next;
        l2 = l2.next;
        ListNode result = current;
        
        while(l1 != null && l2 != null){
            newValue = (l1.val+l2.val+carry)%10;
            ListNode node = new ListNode(newValue);
            current.next = node;
            current = current.next;
            
            carry = (l1.val+l2.val+carry)/10;
            
            //System.out.println("New Value: "+newValue +" Carry: " + carry);
            
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 == null){
            while(l2 != null){
                newValue = (l2.val+carry)%10;
                ListNode node = new ListNode(newValue);
                current.next = node;
                current = current.next;
            
                carry = (l2.val+carry)/10;
            
                l2 = l2.next;
            }
            
        } else if(l2 == null) {
            while(l1 != null){
                newValue = (l1.val+carry)%10;
                ListNode node = new ListNode(newValue);
                current.next = node;
                current = current.next;
            
                carry = (l1.val+carry)/10;
            
                l1 = l1.next;
            }
        
        }
        
        if(carry>0){
                ListNode node = new ListNode(carry);
                current.next = node;
                current.next.next = null;
            }
            
            return result;
    }
}