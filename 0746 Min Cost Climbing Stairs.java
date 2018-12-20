class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] min = new int[len];
        
        min[0] = cost[0];
        min[1] = cost[1];
        
        for(int i=2;i<len;i++){
            min[i] = cost[i] + Math.min(min[i-1], min[i-2]);
        }
        
        return Math.min(min[len-1], min[len-2]);
    }
}