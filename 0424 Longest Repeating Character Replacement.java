class Solution {
    public int characterReplacement(String s, int k) {
        int len = s.length();
        
        MyMap map = new MyMap();
        int ans = 0, left = 0, right = 0;
        int replaceCount = 0;
        int uniqueCount = 0;
        
        while(right < len){
            map.add(s.charAt(right), 1);
            uniqueCount = Math.max(uniqueCount, map.get(s.charAt(right)));
            replaceCount = right - left + 1 - uniqueCount; 
            if(replaceCount > k){
                // start reducing the count from left index tree
                map.add(s.charAt(left), -1);
                left++;
            } else {
                ans = Math.max(ans, right-left+1);
            }
            right++;
        }
        return ans;
    }
    
    class MyMap extends HashMap<Character, Integer> {
        public int get(Character k) {
            return containsKey(k) ? super.get(k) : 0;
        }

        public void add(Character k, int v) {
            put(k, get(k) + v);
        }
    }
}
