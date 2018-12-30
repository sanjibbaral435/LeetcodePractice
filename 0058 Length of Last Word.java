class Solution {
    public int lengthOfLastWord(String s) {
        
        int ind = -1;
        s =  s.trim();
        // find last space
        for(int i=s.length()-1; i>=0; i--){
            if(s.charAt(i) == ' ') {
                ind = i;
                break;
            }
        }
        if(ind==-1) return s.length();
        else return s.substring(ind+1).length();
    }
}