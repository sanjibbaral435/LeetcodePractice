class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        permuteUniqueHelper(nums, 0, nums.length, res, set);
        return res;
    }
    
    public void permuteUniqueHelper(int[] nums, int start, int end,List<List<Integer>> res, Set<List<Integer>> set){
        if(start == end){
            List<Integer> curr = new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                curr.add(nums[i]);
            }
            if(!set.contains(curr)){
                set.add(curr);
                res.add(curr);
            }
        } else {
            for(int i=start; i<end; i++){
                //choose
                swap(nums, start, i);
                
                //explore
                permuteUniqueHelper(nums, start+1, nums.length, res, set);
                
                //unchoose
                swap(nums, start, i);
            }
        }    
    }
    
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}