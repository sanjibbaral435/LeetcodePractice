class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 1;
        int len = nums.length;
        for(int i=1;i<len;i++){
            if(nums[i] != nums[i-1]){
                count++;
                nums[count-1] = nums[i];
            }
            
        }
        return count;
    }
}