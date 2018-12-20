class Solution {
    public int rob(int[] nums) {
        
        int len = nums.length;
        if(len<1) return 0;
        else if(len == 1) return nums[0];
        else if(len == 2) return Math.max(nums[0], nums[1]);
        else{
            int[] rob = new int[len];
            rob[0] = nums[0];
            rob[1] = Math.max(nums[0], nums[1]);

            for(int i=2;i<len;i++){
                rob[i] = Math.max(rob[i-1], rob[i-2]+nums[i]);
            }
            return rob[len-1];            
        }

    }
}