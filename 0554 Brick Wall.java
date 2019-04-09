class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        
        // map which is used to store entries in the form: (sum, count)
        Map<Integer, Integer> map = new HashMap<>();
        
        // We will never obtain the same value of sumsum twice while traversing over a particular row.
        // Thus, if the sumsum value is repeated while traversing over the rows, it means some row's 
        // brick boundary coincides with some previous row's brick boundary. 
        for(int i = 0; i<wall.size(); i++){
            List<Integer> list = wall.get(i);
            int sum = 0;
            for(int j = 0; j<list.size() - 1; j++){
                sum += list.get(j);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
                
            }
        }
        // res = total row - maxCount i.e. min cuts
        int res = wall.size();
        for (int key: map.keySet())
            res = Math.min(res, wall.size() - map.get(key));
        
        return res;

    }
}
