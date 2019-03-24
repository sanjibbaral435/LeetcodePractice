class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(candidates);
        combinationSum2Helper(candidates, target, res, new LinkedList<>(), 0);
        return res;
    }
    
    public void combinationSum2Helper(int[] candidates, int target, List<List<Integer>> res, LinkedList<Integer> curr, int start) {
        if(target < 0) return;
        if(target == 0){
            // add to result
            res.add(new LinkedList<>(curr));
            return;
        } else {
            for(int i=start; i<candidates.length; i++){                
                if(i > start && candidates[i] == candidates[i-1]) continue; // skip duplicates
                //choose
                curr.add(candidates[i]);

                //explore
                combinationSum2Helper(candidates, target - candidates[i], res, curr, i+1);

                //unchoose
                curr.removeLast();    
            }
        }
    }
}