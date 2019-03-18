/*
Divide Conquer Solution
Find shortest bar. maximum area will be the maximum of:
    1. The widest possible rectangle with height equal to the height of the shortest bar.
    2. The largest rectangle confined to the left of the shortest bar(subproblem).
    3. The largest rectangle confined to the right of the shortest bar(subproblem).
    
Time Complexity O(n^2)
*/

class Solution {
    public int largestRectangleArea(int[] heights) {
        return largestRectangleAreaUtil(heights, 0, heights.length-1);
    }
    
    public int largestRectangleAreaUtil(int[] heights, int start, int end) {
        if(start>end) return 0;
        
        int minIndex = start;
        for(int i= start; i<= end; i++){
            if(heights[minIndex] > heights[i]) 
                minIndex = i;
        }
        
        return Math.max((end-start+1)*heights[minIndex],
                       Math.max(largestRectangleAreaUtil(heights, start, minIndex-1), largestRectangleAreaUtil(heights, minIndex+1, end)));
    }
}
