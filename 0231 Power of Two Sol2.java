class Solution {
    public boolean isPowerOfTwo(int num) {
        return (num > 0 && (num & (num - 1)) == 0);
    }
}
