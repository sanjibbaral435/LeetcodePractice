class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new LinkedList<>();
        combineHelp(n, k, 1, res, new LinkedList<Integer>());
        return res;
    }
    
    public void combineHelp(int n, int k, int index, List<List<Integer>> res, LinkedList<Integer> curr) {
        if(k == curr.size()){
            res.add(new LinkedList(curr));
            return;
        }
        
        for(int i = index; i<= n; i++){
            // choose
            curr.add(i);
            
            // explore
            combineHelp(n, k, i+1, res, curr);
            
            // unchoose
            curr.removeLast();
        }
    }
}