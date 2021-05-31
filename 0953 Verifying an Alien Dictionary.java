// Map into hashmap and compare pair of words from start

// Time O(NS) - N=words count. S=String length
// Space O(1)
class Solution {
    Map<Character, Integer> map = new HashMap<>();
    public boolean isAlienSorted(String[] words, String order) {
        int len = order.length();
        for(int i=0; i<len; i++) {
            map.put(order.charAt(i), i);
        }

        // compare pair of words from the beginning
        for(int i=1; i<words.length; i++) {
            if(isBigger(words[i-1], words[i]))
                return false;
        }
        return true;
    }

    public boolean isBigger(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();

        for(int i=0; i<l1 && i< l2; i++) {
            if (s1.charAt(i) != s2.charAt(i))
               return map.get(s1.charAt(i)) > map.get(s2.charAt(i));
        }
        return l1 > l2;
    }
}
