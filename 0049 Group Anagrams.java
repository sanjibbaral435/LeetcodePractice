// Complexity O(NK) N = no of strings. K max length of the strings
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        
        for(String s: strs){
            int[] count = new int[26];
            
            char[] c = s.toCharArray();
            // keep count of all chr
            for(int i=0; i<c.length; i++){
                count[c[i] - 'a']++;
            }
            
            //build the hashtable key from the count array in foramt #0#0#0...
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<count.length; i++){
                sb.append("#");
                sb.append(count[i]);
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
