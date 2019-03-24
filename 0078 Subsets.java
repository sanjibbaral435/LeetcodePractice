class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        subsetsHelper(nums, res, new LinkedList<Integer>(), 0);
        return res;
    }
    
    public void subsetsHelper(int[] nums, List<List<Integer>> res, LinkedList<Integer> curr, int start) {
        // add to result
        res.add(new LinkedList<>(curr));
        for(int i=start; i<nums.length; i++){
            //choose
            curr.add(nums[i]);

            //explore
            subsetsHelper(nums, res, curr, i+1); // i+1, since duplicates not allowed

            //unchoose
            curr.removeLast();
        }
    }
}