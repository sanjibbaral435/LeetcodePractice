class Solution {
    public String reverseVowels(String s) {
        if(s.length() == 0) return s;
        int low = 0;
        int high = s.length()-1;
        
        Character[] arr = {'a','e','i','o','u','A','E','I','O','U'};
        Set<Character> set = new HashSet<Character>(Arrays.asList(arr));
        
        char[] res = new char[s.length()];
        while(low < high){
            while(low<high && !set.contains(s.charAt(low))){
                res[low] = s.charAt(low);
                low++;
            }
            while(high> low && !set.contains(s.charAt(high))) {
                res[high] = s.charAt(high);
                high--;
            }
            
            res[low] = s.charAt(high);
            res[high] = s.charAt(low);
            low++;
            high--;
        }
        // add the mid character in case of odd length
        if(low == high)
            res[low] = s.charAt(high);
        return String.valueOf(res);
    }
}
