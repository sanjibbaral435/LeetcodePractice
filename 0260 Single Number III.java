class Solution {
    public int[] singleNumber(int[] nums) {
        int res = 0;
        
        // xor of the two unique elements
        for(int i=0;i<nums.length;i++){
            res = res^nums[i];
        }
        
        //find the rightmost set bit of this result
		//the two unique numbers must have this bit 
		//different since this bit is set in the xor of the two numbers
        res &= -res;
        
        int[] rets = {0, 0}; 
        for(int i=0;i<nums.length;i++){
            if((nums[i] & res) == 0){
                // xor all numbers who has this bit not set
                rets[0] ^= nums[i];  
            } else {
                // xor all numbers who has this bit set
                rets[1] ^= nums[i]; 
            }
        }
        return rets;
    }
}