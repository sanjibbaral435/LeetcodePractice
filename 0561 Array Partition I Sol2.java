// Time complexity O(nlogn) due to sorting
// space complexity constant

class Solution {
    public int arrayPairSum(int[] nums) {
        int sum = 0;
        Arrays.sort(nums);
        for(int i=0; i<nums.length;i=i+2){
            sum = sum + nums[i];
        }
        return sum;
    }
}