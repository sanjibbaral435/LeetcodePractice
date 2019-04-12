class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        
        int rows = envelopes.length;
        if(rows == 0) return 0;
        int cols = envelopes[0].length;
        
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(final int[] entry1, final int[] entry2) {
                if(entry1[0] == (entry2[0])){
                    // if width equals, sort by decreasing height
                    return entry2[1] - entry1[1];     
                } else {
                    // sort by increasing width
                    return entry1[0] - entry2[0];
                }
            }
        });   
        
        // Now run a LIS on the array where increase means increase in both width and height
        
        int[] dp = new int[rows];
        
        int res = 0;
        for(int i=0; i<rows; i++){
            int max_val = 0;
            for(int j = 0; j<i; j++){
                if(envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1]){
                    max_val = Math.max(max_val, dp[j]);
                }
            }
            dp[i] = max_val+1;
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
