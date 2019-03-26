class Solution {
    public void sortColors(int[] nums) {
        int j = 0; // last index of sorted 0
        int k = nums.length - 1; // index of first index of sorted 2
        
        for(int i = 0; i<=k; i++){
            if(nums[i] == 0) {
                swap(nums, i, j);
                j++;
            }
            if(nums[i] == 2) {
                swap(nums, i, k);
                k--;
                i--; // it might have brought a zero to current i location. so next should start from this location
            }
        }
    }
    
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}