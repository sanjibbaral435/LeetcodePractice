// DP Based Time Complexity O(n^2)
// min[i][0] hold the min steps required to reach ith index
// min[i][1] hold the index from which this can be reached

class Solution {
    public int jump(int[] nums) {
        int[][] min = new int[nums.length][2];
        
        min[0][0] = 0;
        min[0][1] = 0;
        
        for(int i=1; i< nums.length; i++){
            int j = min[i-1][1];
            while(j < i){
                if(nums[j] + j >= i) {
                    min[i][0] = min[j][0] + 1;
                    min[i][1] = j;
                    break;
                } else {
                    j++;
                }
            }
        }
        return min[nums.length-1][0];
    }
}