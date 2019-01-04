class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] map = new int[26];
        
        for(int i=0; i<magazine.length(); i++){
            map[magazine.charAt(i)-97]++;
        }

        for(int i=0; i<ransomNote.length(); i++){
            if(map[ransomNote.charAt(i)-97] == 0) return false;
            map[ransomNote.charAt(i)-97]--;
        }
        return true;
        
    }
}