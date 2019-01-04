class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        if(numRows == 0) return res;
        
        List<Integer> first = new ArrayList<Integer>();
        first.add(1);
        res.add(first);
        
        
        for(int i=1; i< numRows; i++){
            List<Integer> currList = new ArrayList<Integer>();

            for(int j=0; j<=i; j++){
                List<Integer> prevList = res.get(i-1);
                
                if(j == 0 || i==j) currList.add(1); 
                else currList.add(prevList.get(j-1) + prevList.get(j));
            }
            res.add(currList);
        }
        return res;
    }
}