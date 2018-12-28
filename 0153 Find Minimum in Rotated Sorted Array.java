class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        // initializing left and right pointers.
        int lo = 0, hi = nums.length-1;
        
        // if the last element is greater than the first element then there is no rotation.
        // Hence the smallest element is first element. A[0]
        if (nums[hi] > nums[lo]) {
          return nums[0];
        }
        
        while(lo < hi){
            int mid = (lo+hi)/2;
            if(nums[mid+1] < nums[mid]) return nums[mid+1];
            
            // min is in left half including the mid. Hence hi = mid not mid-1
            if(nums[mid] < nums[lo]){
                hi = mid;
            } else {
                lo = mid+1;
            }
        }
        return nums[lo];
    }
}