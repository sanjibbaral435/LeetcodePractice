/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();
        
        ListNode temp = l1;
        while(temp != null){
            stack1.push(temp.val);
            temp = temp.next;
        }
        
        temp = l2;
        while(temp != null){
            stack2.push(temp.val);
            temp = temp.next;
        }
        
        
        ListNode list = new ListNode(0);
        int sum = 0;
        while(!stack1.isEmpty() || !stack2.isEmpty()){
            if(!stack1.isEmpty()) sum = sum + stack1.pop();
            if(!stack2.isEmpty()) sum = sum + stack2.pop();
            
            list.val = sum%10;
            ListNode head = new ListNode(sum/10);
            head.next = list;
            list = head;
            sum = sum/10; //carry
        }
        return list.val == 0 ? list.next : list;
    }
}
