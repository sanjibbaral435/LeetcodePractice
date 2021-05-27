// idea is to scan from both end and when the first mismatch found, we will check the separately
// once by ingnoring the first mismatch char and then the second

// Time O(n)
// Space O(1)
class Solution {
    public boolean validPalindrome(String s) {
        if(s.isEmpty())
            return true;
        int l = 0;
        int r = s.length()-1;
        while(l<r) {
            if(s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            } else {
                return isPalindrome(s, l+1, r) || isPalindrome(s, l, r-1);
            }
        }
        return true;
    }

    public boolean isPalindrome(String s, int l, int r) {
        while(l < r) {
            if(s.charAt(l) != s.charAt(r))
                return false;
            else {
                l++;
                r--;
            }
        }
        return true;
    }
}
