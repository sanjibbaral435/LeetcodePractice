class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0) return 0;
        
        int len1 = haystack.length();
        int len2 = needle.length();
        
        if(len2 > len1) return -1;
        
        int i = 0, j = 0, count = 0;
        int index = -1;
        
        while(i<len1 && j<len2){
            if(i+j > len1-1) return -1;
            if(haystack.charAt(i+j) == needle.charAt(j)){
                if(count == 0) index = i;
                count++;
                //i++;
                j++;
            } else {
                i++;
                count = 0;
                index = -1;
                j = 0;

            }
        }
        if(count < len2) return -1;
        else return index;
    }
}