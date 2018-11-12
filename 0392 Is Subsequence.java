class Solution {
    public boolean isSubsequence(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        
        int i = 0;
        int j = 0;
        
        while(j < len2 && i < len1){
            if(s.charAt(i) == t.charAt(j)){
                i++; j++;
            } else {
                j++;
            }
        }
        
        if(i == len1) return true;
        else return false;
        
    }
}