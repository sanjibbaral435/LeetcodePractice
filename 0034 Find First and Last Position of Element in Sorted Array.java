class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int high = nums.length;
        int low = 0;
        int mid = 0;
        int[] res = {-1, -1};
        
        if(nums.length == 0) return res;
        //find left appearance
        // will be run till low=high
        while(low<high){
            mid = (low+high)/2;
            if(target > nums[mid]){
                // definitely in right half
                low = mid+1;
            } else {
                // definitely in left half
                high = mid;
            }
        }
        
        if(low >= nums.length || nums[low] != target) return res;
        res[0] = low;
        
        low = 0;
        high = nums.length;
        
        while(low<high){
            mid = (low+high)/2;
            if(target < nums[mid]){
                // definitely in left half
                high = mid;
            } else {
                // definitely in right half
                low = mid+1;
            }
        }
        res[1] = low-1;
        return res;
    }
}