// Extends the Normal House Robber Problem
// Use that as helper function for 2 set of inputs

class Solution {
    public int rob(int[] nums) {
        //Max of the two options
        // include the first exclude the last
        // exclude the first and include the last
        if (nums.length == 1) return nums[0];
        return Math.max(rob_helper(nums, 0, nums.length - 2), rob_helper(nums, 1, nums.length - 1));
    }
    
    public int rob_helper(int[] nums, int start, int end) {
        int len = end-start+1;
        if(len<1) return 0;
        else if(len == 1) return nums[start+0];
        else if(len == 2) return Math.max(nums[start+0], nums[start+1]);
        else{
            int[] rob = new int[len];
            rob[0] = nums[start+0];
            rob[1] = Math.max(nums[start+0], nums[start+1]);

            for(int i=2;i<len;i++){
                rob[i] = Math.max(rob[i-1], rob[i-2]+nums[start+i]);
            }
            return rob[len-1];            
        }
    }
}