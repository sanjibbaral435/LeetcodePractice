// Expand Around Center
// Let N be the length of the string. The middle of the palindrome could be in one of 2N - 1 positions: either at letter or between two letters.
// For each center, let's count all the palindromes that have this center.
// Time Complexity O(n^2)
// Space Complexity O(1)


class Solution {
    public int countSubstrings(String S) {
        int N = S.length(), ans = 0;
        for (int center = 0; center <= 2*N-1; ++center) {
            int left = center / 2;
            int right = left + center % 2;
            while (left >= 0 && right < N && S.charAt(left) == S.charAt(right)) {
                ans++;
                left--;
                right++;
            }
        }
        return ans;
    }
}