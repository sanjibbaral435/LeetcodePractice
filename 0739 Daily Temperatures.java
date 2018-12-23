// https://leetcode.com/articles/daily-temperatures/

class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] ans = new int[T.length];
        Stack<Integer> stack= new Stack();
        
        for(int i=T.length-1;i>=0;i--){
            while(!stack.isEmpty() && T[i] >= T[stack.peek()]){
                // if stack is not empty, pop elements untill we find the
                // first elemnt which is greater than current element
                stack.pop();
            }
            
            ans[i] = stack.isEmpty()? 0 : stack.peek()-i;
            stack.push(i);
        }
        return ans;
        
    }
}