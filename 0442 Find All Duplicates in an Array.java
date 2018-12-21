// when find a number i, flip the number at position i-1 to negative. 
// if the number at position i-1 is already negative, i is the number that occurs twice.

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if(nums == null || nums.length < 1) return list;
        for(int i=0;i<nums.length;i++){
            int val = Math.abs(nums[i])-1;
            //System.out.println("Val: " + val);
            if(nums[val] < 0) {
                list.add(Math.abs(nums[i]));   
            } else {
                nums[val] = -nums[val];    
            }
            //System.out.println("Nums: " + Arrays.toString(nums));
        }
        return list;
    }
}