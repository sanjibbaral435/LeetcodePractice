// https://www.youtube.com/watch?v=WepWFGxiwRs
// Time Complexity O(n^2)

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        //put all words from dict into a set
        Set<String> set=new HashSet(wordDict);
        int len = s.length();
        boolean[] dp = new boolean[len+1];
        dp[0] = true;
        
        for(int i=1; i<=len; i++){
            // j is the index of division of substring from 0 to i
            for(int j=0; j<i; j++){
                if(dp[j] && set.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }    
        }
        return dp[len];
            
    }
}
