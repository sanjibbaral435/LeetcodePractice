// DP Solution
// dp[i][j] = dp[i+1][j-1] + 2 if s.charAt(i) == s.charAt(j)
// otherwise, dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1])

class Solution {
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        
        //all diagonal elements are single length char hence palindrom
        for(int i=0;i<len;i++){
            dp[i][i] = 1;
        }
        
        for(int k=2; k<=len; k++){
            for(int i=0; i<len-k+1; i++){
                // Get the ending index of subsequence from 
                // starting index i and length k 
                int j = i + k - 1; 
                if(s.charAt(i) == s.charAt(j)) dp[i][j] = dp[i+1][j-1]+2;
                else dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
            }
        }
        
        return dp[0][len-1];
    }
}