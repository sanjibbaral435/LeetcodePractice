class Solution {
    public int climbStairs(int n) {
        if(n==0) return 0;
        if(n==1) return 1;
        
        int[] climbs = new int[n];
        climbs[0] = 1;
        climbs[1] = 2;
        for(int i=2; i<n; i++){
            climbs[i] = climbs[i-1]+climbs[i-2];
        }
        
        return climbs[n-1];
    }
}