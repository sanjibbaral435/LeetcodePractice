class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        
        for(String s: strings){            
            //build the hashtable key from the string with difference between each adjacent character
            // i.e. abc = #1#1#, acd = #2#1#, a = # etc.
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<s.length(); i++){
                sb.append("#");
                if(i == s.length() -1) break;
                
                int diff = s.charAt(i+1) - s.charAt(i);
                if(diff < 0) diff = 26 + diff; //modular difference, cylcing around 26
                
                sb.append(String.valueOf(diff));
                
            }
            
            String key = sb.toString();
            
            // does not contain the key
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<String>());
            }
            
            map.get(key).add(s);
        }
        
        List<List<String>> res = new ArrayList<List<String>>(); 
        // iterate over hashmap
        for (String key : map.keySet()) {
            res.add(map.get(key));
        }
        
        return res;
    }
}
