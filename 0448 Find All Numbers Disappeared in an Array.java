// mark elements as negative using nums[nums[i] -1] = -nums[nums[i]-1]

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        
        for(int i=0;i<nums.length;i++){
            int index = Math.abs(nums[i]);
            if(nums[index-1]  > 0) nums[index-1] = -nums[index-1];
        }
        
        for(int i=0;i<nums.length;i++){
            if(nums[i] > 0) list.add(i+1);
        }
        return list;
    }
}