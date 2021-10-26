// Time Complexity O(N!)
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> numsList = new ArrayList();
        for (int num : nums)
            numsList.add(num);

        List<List<Integer>> res = new ArrayList<>();
        int first = 0;
        permuteUtil(nums.length, numsList, res, first);

        return res;
    }

    public void permuteUtil(int n, List<Integer> nums, List<List<Integer>> res, int first) {
        if(first == n) {
            // reached an end of permutation
            res.add(new ArrayList<Integer>(nums));
            return;
        }

        for(int i=first; i<n; i++) {
            //swap first and i
            Collections.swap(nums, first, i);

            //permute by fixing the current element
            permuteUtil(n, nums, res, first+1);

            //backtrack
            Collections.swap(nums, first, i);
        }
    }

}
