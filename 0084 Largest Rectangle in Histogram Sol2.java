/*

1) Create an empty stack.
2) Start from first bar, and do following for every bar 'heights[i]'' where 'i' varies from 0 to n-1.
    a) If stack is empty or heights[i] is higher than the bar at top of stack, then push 'i' to stack.
    b) If this bar is smaller than the top of stack, then keep removing the top of stack while top of the stack is greater. Let the removed bar be heights[tp]. Calculate area of rectangle with heights[tp] as smallest bar. For heights[tp], the ‘left index’ is previous (previous to tp) item in stack and ‘right index’ is ‘i’ (current index).

3) If the stack is not empty, then one by one remove all bars from stack and do step 2.b for every removed bar.
    
Time Complexity O(n)
Space Complexity O(n)
*/

class Solution {
    public int largestRectangleArea(int[] heights) {
        
        // Create an empty stack. The stack holds indexes of heights[] array 
        // The bars stored in stack are always in increasing order of their 
        // heights.
        Stack<Integer> stack = new Stack<>();
        
        int max_area = 0; // Initialize max area 
        int tp;  // To store top of stack 
        int area_with_top; // To store area with top bar as the smallest bar 
        
        int i=0;
        while(i<heights.length){
            
            // If this bar is higher than the bar on top stack, push it to stack 
            if(stack.isEmpty() || heights[i] >= heights[stack.peek()]) stack.push(i++);
            
            // If this bar is lower than top of stack, then calculate area of rectangle  
            // with stack top as the smallest (or minimum height) bar. 'i' is  
            // 'right index' for the top and element before top in stack is 'left index' 
            else {
                tp = stack.peek();  // store the top index 
                stack.pop();  // pop the top
                
                // Calculate the area with heights[tp] stack as smallest bar 
                area_with_top = heights[tp] * (stack.empty() ? i : i - stack.peek() - 1);
                
                // update max area, if needed 
                if (max_area < area_with_top) 
                    max_area = area_with_top;
            }
        }
        
        // Now pop the remaining bars from stack and calculate area with every 
        // popped bar as the smallest bar 
        while (stack.empty() == false) 
        { 
            tp = stack.peek(); 
            stack.pop(); 
            area_with_top = heights[tp] * (stack.empty() ? i : i - stack.peek() - 1); 
       
            if (max_area < area_with_top) 
                max_area = area_with_top; 
        } 
       
        return max_area; 
    }
}
