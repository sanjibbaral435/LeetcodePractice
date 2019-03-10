// Count the number of bits set in n
// all power of 2 has only 1 bit set
class Solution {
    public boolean isPowerOfTwo(int n) {
        int count = 0; 
        while (n > 0) 
        { 
            count += n & 1; 
            n >>= 1; 
        } 
        return (count == 1); 
    }
}
