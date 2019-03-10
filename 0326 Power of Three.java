/*
In Base 10, all powers of 10 start with the digit 1 and then are followed only by 0 (e.g. 10, 100, 1000).
This is true for other bases and their respective powers. 2 base 10 is 10 base 2, 4 base 10 is 100 base 2 and so on.
*/
class Solution {
    public boolean isPowerOfThree(int n) {
        return Integer.toString(n, 3).matches("10*");    
    }
}
