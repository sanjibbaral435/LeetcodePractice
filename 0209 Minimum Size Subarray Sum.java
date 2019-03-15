class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        
        int left = 0;
        
        for(int right=0; right< nums.length; right++){
            sum += nums[right];
            while(sum >= s){
                min = Math.min(min, right-left+1);
                sum = sum - nums[left++];
            }
        }
        return (min != Integer.MAX_VALUE) ? min : 0;
    }
}
