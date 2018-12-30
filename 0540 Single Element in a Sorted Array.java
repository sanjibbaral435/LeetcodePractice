class Solution {
    public int singleNonDuplicate(int[] nums) {
        // binary search
        // Basically we want to find the first even-index number not followed by the same number
        int n=nums.length, lo=0, hi=n/2;
        while (lo < hi) {
            int m = (lo + hi) / 2;
            if (nums[2*m]!=nums[2*m+1]) hi = m;
            else lo = m+1;
        }
        return nums[2*lo];
    }
}