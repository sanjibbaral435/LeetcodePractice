// Sliding Window Approach
// Time Complexity O(n)
// Space Complexity O(1) since we will hold only 3 values in HashMap

class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int len = s.length();
        if(len <= 2) return len;
        
        MyMap map = new MyMap();
        int ans = 0, left = 0, right = 0;
        
        while(right < len){
            map.add(s.charAt(right), 1);
            while(map.size() >= 3){
                // start reducing the count frfom left index tree
                map.add(s.charAt(left), -1);
                if(map.get(s.charAt(left)) == 0)
                    map.remove(s.charAt(left));
                left++;
            }
            ans = Math.max(ans, right-left+1);
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
