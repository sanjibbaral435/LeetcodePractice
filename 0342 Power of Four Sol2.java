/*
Same as base of 2..binary will contain only 1 set bit but the position of the bit should be even (from right side considering indexes are 0,1,2..)
*/
class Solution {
    public boolean isPowerOfFour(int n) {
        if(n <= 0) return false;
        int count = 0;
        int index = 0;
        int i = 0;
        while (n > 0) 
        { 
            if((n & 1) == 1){
                count++;
                if(count > 1) return false;
                index = i;
            }
            n >>= 1;
            i++;
        } 
        return (index%2 == 0);
    }
}
