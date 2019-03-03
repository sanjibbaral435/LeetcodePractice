// Same Problem as
// https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/
// Sliding Window Approach
// Time Complexity O(n)
// Space Complexity O(1) since we will hold only 3 values in HashMap
class Solution {
    public int totalFruit(int[] tree) {
        int len = tree.length;
        if(len <= 2) return len;
        
        MyMap map = new MyMap();
        int ans = 0, left = 0, right = 0;
        
        while(right < len){
            map.add(tree[right], 1);
            while(map.size() >= 3){
                // start reducing the count frfom left index tree
                map.add(tree[left], -1);
                if(map.get(tree[left]) == 0)
                    map.remove(tree[left]);
                left++;
            }
            ans = Math.max(ans, right-left+1);
            right++;
        }
        return ans;
    }
    
    class MyMap extends HashMap<Integer, Integer> {
        public int get(int k) {
            return containsKey(k) ? super.get(k) : 0;
        }

        public void add(int k, int v) {
            put(k, get(k) + v);
        }
    }
}
