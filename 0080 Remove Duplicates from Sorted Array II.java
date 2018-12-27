class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 1;
        int len = nums.length;
        int repeat = 1;
        for(int i=1;i<len;i++){
            if(nums[i] != nums[i-1]){
                repeat = 1;
                count++;
                nums[count-1] = nums[i];
            } else {
                if(repeat<2){
                    repeat++;
                    count++;
                    nums[count-1] = nums[i];
                }
                
            }
        }
        return count;
    }
}