class Solution {
    public boolean wordPattern(String pattern, String str) {
        HashMap<Character, String> map = new HashMap<>(); 
        String[] tokens = str.split(" ");
        
        if(pattern.length() != tokens.length) return false;
        
        for(int i=0; i<pattern.length(); i++){
            if(map.containsKey(pattern.charAt(i))){
                if(map.get(pattern.charAt(i)).equals(tokens[i])) continue;
                else return false;
            } else {
                if(map.containsValue(tokens[i]))
                    return false;
                else map.put(pattern.charAt(i), tokens[i]); 
            }
        }
        return true;
    }
}