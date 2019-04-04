// Binary Search
// If it's ascending peak will be on right
// If descending peak will be on left half;
class Solution {
    public int findPeakElement(int[] nums) {
        int lo = 0;
        int hi = nums.length-1;
        
        while(lo < hi){
            int mid = lo + (hi-lo)/2;
            
            if(nums[mid+1] > nums[mid]){
                // peak is in right half i.e. it's ascending at mid point
                lo = mid+1;
            } else {
                hi = mid;
            }
        }
        
        return lo;
    }
}
