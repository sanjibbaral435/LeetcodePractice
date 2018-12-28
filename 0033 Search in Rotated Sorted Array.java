// Modified binary search

class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 0) return -1;
        int low = 0, high = nums.length-1;
        while(low < high){
            int mid = (low + high)/2;
            
            if (nums[mid] == target) return mid;
            // if the mid is before rotation
            if(nums[low] <= nums[mid]){
                if(target >= nums[low] && target < nums[mid]) high = mid-1;
                else low = mid+1;
            }
            // if the mid is after rotation
            else {
                if(target > nums[mid] && target <= nums[high]) low = mid+1;
                else high = mid-1;
            }
        }
        
        // here low==high. so take anything
        if(nums[high] == target) return high;
        else return -1;
    }
}