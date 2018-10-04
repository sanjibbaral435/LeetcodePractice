// Will follow the apporach of finding a cycle in linkedList
// fast and slow whenever meet, if the meeting point is 1 then
// it's a happy number else not.

class Solution {
    public boolean isHappy(int n) {
        int fast = n;
        int slow = n;
        
        do{
          slow = squareSumOfDigits(slow);
          fast = squareSumOfDigits(squareSumOfDigits(fast));  
        } while (fast != slow);
        
        if(fast == 1) return true;
        return false;
        
    }
    
    public int squareSumOfDigits(int n){
        int sum = 0;
        while(n!=0) {
            int x = n%10;
            sum += x*x;
            n = n/10;
        }
        return sum;
    }
}