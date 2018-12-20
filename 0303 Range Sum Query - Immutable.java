class NumArray {
    int[] sum;

    public NumArray(int[] nums) {
        sum = new int[nums.length];
        if(nums == null || nums.length == 0) return;
        calculateSum(nums);
    }
    
    public void calculateSum(int[] nums){
        sum[0] = nums[0];
        for(int i=1; i<nums.length; i++){
                sum[i] = sum[i-1] + nums[i];
        }
    }
    
    public int sumRange(int i, int j) {
        if(i == 0) return sum[j];
        else return sum[j] - sum[i-1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */