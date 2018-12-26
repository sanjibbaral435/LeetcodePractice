// Sliding window. Keep on increasing max untill we get an element which is smaller or equal than its previous. Then change the start to that point and keep on sliding 
class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if(nums == null || nums.length==0) return 0;
        int max = 0; int start = 0;
        for(int i=0; i<nums.length; i++){
            if(i > 0 && nums[i-1] >= nums[i]) start = i;
            max = Math.max(max, i-start+1);    
        } 
        return max;
    }
}