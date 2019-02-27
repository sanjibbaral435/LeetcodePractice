class Solution {
    public int maxProduct(int[] nums) {
        
        // max/min stores the max/min product of
        // subarray that ends with the current number A[i]
        int min = nums[0];
        int max = nums[0];
        
        // store the result that is the max we have found so far
        int prod = nums[0];
        
        for(int i=1; i<nums.length; i++){
            // multiplied by a negative makes big number smaller, small number bigger
            // so we redefine the extremums by swapping them
            if(nums[i] < 0){
                int temp = max;
                max = min;
                min = temp;
            }
            
            // max/min product for the current number is either the current number itself
            // or the max/min by the previous number times the current one
            // when it encounters nums[i], it has two choices: absorb nums[i] to the product
            // or start a new continuous subarray start with nums[i]. 
            // This is what "max = Math.max(nums[i], max * nums[i]);" does.
            max = Math.max(nums[i], nums[i]*max);
            min = Math.min(nums[i], nums[i]*min);
            
            prod = Math.max(prod, max);
        }
        
        return prod;
    }
}