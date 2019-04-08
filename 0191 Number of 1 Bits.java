public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int index = 0;
        int count = 0; 
        while (index < 32) 
        { 
            count += n & 1; 
            n >>= 1;
            index++;
        } 
        return count;
    }
}
