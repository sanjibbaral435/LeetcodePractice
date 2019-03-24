class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new LinkedList<>();
        combinationSum3Helper(k, n, res, new LinkedList<>(), 1);
        return res;
    }
    
    public void combinationSum3Helper(int targetSize, int target, List<List<Integer>> res, LinkedList<Integer> curr, int start) {
        if(target < 0 || curr.size() > targetSize) return;
        if(target == 0 && curr.size() == targetSize){
            // add to result
            res.add(new LinkedList<>(curr));
            return;
        } else {
            for(int i=start; i<10; i++){                
                //choose
                curr.add(i);

                //explore
                combinationSum3Helper(targetSize, target - i, res, curr, i+1);

                //unchoose
                curr.removeLast();    
            }
        }
    }
}