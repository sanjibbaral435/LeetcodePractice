// Time Complexity O(N!)
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        permuteHelper(nums, 0, nums.length, res);
        return res;
    }
    
    public void permuteHelper(int[] nums, int start, int end, List<List<Integer>> res){
       if(start == end){
            List<Integer> curr = new ArrayList<Integer>();
            for(int i = 0; i< nums.length; i++){
                curr.add(nums[i]);
            }
            res.add(curr);
        } else {
            for(int i = start; i<end; i++){
                //choose
                swap(nums, start, i);

                //explore
                permuteHelper(nums, start+1, nums.length, res);

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