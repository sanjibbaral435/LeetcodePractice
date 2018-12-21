// recurrence for this problem is f[i] = f[i / 2] + i % 2.

class Solution {
    public int[] countBits(int num) {
        int[] count = new int[num+1];
        for(int index=0;index<=num;index++){
            int i = index;
            count[i] = count[i >> 1] + (i&1);
        }
        return count;
    }
}