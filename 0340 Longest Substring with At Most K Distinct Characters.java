// Sliding Window Approach
// Time Complexity O(n)
// Space Complexity O(k) since we will hold only k+1 values in HashMap

class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int len = s.length();
        if(k == 0) return 0;
        if(len <= k) return len;
        
        MyMap map = new MyMap();
        int ans = 0, left = 0, right = 0;
        
        while(right < len){
            map.add(s.charAt(right), 1);
            while(map.size() > k){
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
