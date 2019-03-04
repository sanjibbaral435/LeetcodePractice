/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// Using priority queue add all the heads and keep on poping and adding to the result list
// Time complexity O(Nlogk)
// Space Complexity O(N)
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(new Comparator<ListNode>(){
            @Override
            public int compare(ListNode a, ListNode b){
                return a.val - b.val;
            }
        });
        
        ListNode dummy = new ListNode(0);
        ListNode tail=dummy;
        // add all the heads to the priority queue
        for(ListNode node: lists){
            if(node != null)
                queue.add(node);
        }
        
        while(!queue.isEmpty()){
            tail.next = queue.poll();
            tail = tail.next;
            
            if(tail.next != null){
                queue.add(tail.next);
            }
        }
        return dummy.next;
    }
}
