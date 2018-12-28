class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums.length == 1 && target == nums[0]) return 0;
        int lo = 0;
        int hi = nums.length-1;
        while(lo<=hi){
            if(target<nums[lo]) return lo;
            if(target>nums[hi]) return hi+1;
            
            int mid = (lo+hi)/2;
            if(nums[mid] == target) return mid;
            
            if(target > nums[mid]){
                lo = mid+1;
            } else {
                hi = mid-1;
            }
        }
        return -1;
    }
}