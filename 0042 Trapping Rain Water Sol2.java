// Using Dynamic Programming
// If there is a larger bar at one end (say right), we are assured that the water trapped would be dependant on height of bar in current direction (from left to right). As soon as we find the bar at other end (right) is smaller, we start iterating in opposite direction (from right to left). We must maintain left_max and right_max during the iteration

// Time Complexity O(n)
// Space Complexity O(1)
class Solution {
    public int trap(int[] height) {
        if(height.length == 0) return 0;
        
        int leftMax = 0, rightMax = 0;
        int left = 0, right = height.length-1;
        
        int ans = 0;
        
        while(left < right){
            if(height[left] < height[right]){
                if(height[left] > leftMax) leftMax = height[left];
                else ans = ans + (leftMax - height[left]);
                left++;
            } else {
                if(height[right] > rightMax) rightMax = height[right];
                else ans = ans + (rightMax - height[right]);
                right--;
            }            
        }
        
        return ans;
    }
}
