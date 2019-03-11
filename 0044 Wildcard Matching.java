/*
Reference:
https://www.geeksforgeeks.org/wildcard-pattern-matching/

T[i][j] = is the wildcard match upto index i of string and index j of pattern
T[i][j] = T[i-1][j-1]   if(s[i] == p[j] || p[j] == '?') //if it's other than '*'
            
        // if p[j] '*'
        = T[i][j-1] {this is for zero occurence}
          || T[i-1][j]  {this is for any sequence}    
        
        // for all other cases
        = false
*/

class Solution {
    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        boolean T[][] = new boolean[sLen+1][pLen+1];

        // both text and pattern are null
        T[0][0] = true; 

        // text is empty. This has corner cases like pattern a* or a*b* etc.
        for(int i = 1; i< pLen+1; i++){
            if(p.charAt(i-1) == '*')
            T[0][i] = T[0][i-1];
        }
        
        for(int i = 1; i< sLen+1; i++){
            for(int j = 1; j< pLen+1; j++){
                if(p.charAt(j-1) == '?' || s.charAt(i-1) == p.charAt(j-1)){
                    T[i][j] = T[i-1][j-1]; 
                } else if(p.charAt(j-1) == '*'){
                    T[i][j] = T[i][j-1] || T[i-1][j];  // for zero occurance of the prev char
                } else {
                    T[i][j] = false; 
                }
            }
        }
        
        return T[sLen][pLen];
    }
}
