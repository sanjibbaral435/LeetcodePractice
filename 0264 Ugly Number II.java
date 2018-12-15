/*
https://www.geeksforgeeks.org/ugly-numbers/
*/

class Solution {
    public int nthUglyNumber(int n) {
        if(n==0) return 0;
        if(n==1) return 1;
        
        int next2 = 2;
        int next3 = 3;
        int next5 = 5;
        
        int index2 = 0, index3 = 0, index5 = 0;
        
        int ugly[] = new int[n];
        ugly[0] = 1;
        
        for(int i=1; i<n; i++){
            int next_ugly = Math.min(next2, Math.min(next3, next5));
            ugly[i] = next_ugly; 
            if(next_ugly == next2){
                index2++;
                next2 =2*ugly[index2];
            }
            if(next_ugly == next3){
                index3++;
                next3 = 3*ugly[index3];
            }
            if(next_ugly == next5){
                index5++;
                next5 = 5*ugly[index5];
            }
        }
        return ugly[n-1];
    }
}