class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        
        // if both length differs by 2 or more then they cant be at one edit distance
        if(Math.abs(len1 - len2) > 1) return false;
        
        int i = 0, j = 0;
        
        int editCount = 0;
        while(i < len1 && j < len2){
            if(s.charAt(i) == t.charAt(j)){
                // both character matches so just proceed.
                i++;
                j++;
            } else {
                // count was already one. and still this character mismatched. so false
                if(editCount == 1) return false;
                
                // now we have to increment the edit count
                
                // if len mismatches, proceed that longer one. (considering there will be one insert in the smaller one)
                if(len1 < len2)
                    j++;
                else if(len1 > len2)
                    i++;
                else {
                    i++;
                    j++;
                }
                editCount++;
            }
            
        }
        // If last character is extra in any string 
        if (i < len1 || j < len2) 
            editCount++; 
        
        return (editCount == 1);
    }
}
