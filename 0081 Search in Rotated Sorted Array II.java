class Solution {
    public boolean search(int[] nums, int target) {
        if(nums.length == 0) return false;
        int low = 0, high = nums.length-1;
        while(low < high){
			// This is exactly same as 33. Search in Rotated array with distinict elements
			// Only difference once we find duplicates here, we skip them from both left and right
		
            // skip duplicates from the left
            while (low < high && nums[low] == nums[low + 1]) low++;
            
            // skip duplicates from the right
            while (high > low && nums[high] == nums[high - 1]) high--; 
            
            int mid = (low + high)/2;
            
            if (nums[mid] == target) return true;
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
        return (nums[high] == target)? true: false;
    }
}