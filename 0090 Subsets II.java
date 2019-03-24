class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);
        subsetsWithDupHelper(nums, res, new LinkedList<Integer>(), 0);
        return res;
    }
    
    public void subsetsWithDupHelper(int[] nums, List<List<Integer>> res, LinkedList<Integer> curr, int start) {
        // add to result
        res.add(new LinkedList<>(curr));
        for(int i=start; i<nums.length; i++){
            if(i > start && nums[i] == nums[i-1]) continue;
            //choose
            curr.add(nums[i]);

            //explore
            subsetsWithDupHelper(nums, res, curr, i+1); // i+1, since duplicates not allowed

            //unchoose
            curr.removeLast();
        }
    }
}