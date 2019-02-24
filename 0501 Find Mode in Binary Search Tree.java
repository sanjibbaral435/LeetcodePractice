/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Integer prev = null;
    int count = 1;
    int max = 0;
    
    public int[] findMode(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        findModeUtil(root, list);
        int[] arr = new int[list.size()]; 
  
        // ArrayList to Array Conversion 
        for (int i =0; i < list.size(); i++) 
            arr[i] = list.get(i);
        return arr;
    }
    public void findModeUtil(TreeNode root, List<Integer> list){
        if(root == null) return;
        
        findModeUtil(root.left, list);
        
        if(prev != null){
            if (root.val == prev)
                count++;
            else
                count = 1;
        }
        
        if(count > max){
            list.clear();
            list.add(root.val);
            max = count;
        } else if (count == max) {
            list.add(root.val);
        }
        prev = root.val;
        findModeUtil(root.right, list);
    }
    
}
