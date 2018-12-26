class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int res = 1;
        for(int i=1; i<nums.length; i++){
            int max_val = 0;
            for(int j=0; j<i; j++){
                if(nums[i] > nums[j]){
                    // find the max of all dp[j]
                    max_val = Math.max(max_val, dp[j]);
                }
            }
            dp[i] = max_val +1;
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}