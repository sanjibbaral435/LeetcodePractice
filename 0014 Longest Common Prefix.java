class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        for(int i = 0; i<strs[0].length(); i++){
            char c = strs[0].charAt(i);
            for(int j = 1; j<strs.length; j++){
                // either we reached end of any string or we reached first mismatch char in any of the strings
                if(i == strs[j].length() || c != strs[j].charAt(i))
                    return strs[0].substring(0, i);
            }
        }
        // if we reached the end of the first( or any thing can be choosen as first string)
        return strs[0];
    }
}