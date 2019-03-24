class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();
        combinationSum(candidates, target, res, new LinkedList<Integer>(), 0);
        return res;
    }
    
    public void combinationSum(int[] candidates, int target, List<List<Integer>> res, LinkedList<Integer> curr, int start) {
        if(target < 0) return;
        if(target == 0){
            // add to result
            res.add(new LinkedList<>(curr));
            return;
        } else {
            for(int i=start; i<candidates.length; i++){
                //choose
                curr.add(candidates[i]);
                
                //explore
                combinationSum(candidates, target - candidates[i], res, curr, i); // i not i+1, since duplicates allowed

                //unchoose
                curr.removeLast();
            }
        }
    }
}