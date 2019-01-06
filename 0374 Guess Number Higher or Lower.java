/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        long lo = 1;
        long hi = n;
        
        int mid =(int) ((lo+hi)/2);
        
        while(0 != guess(mid)){
            if(guess(mid) == -1){
                hi = mid-1;
            } else {
                lo = mid+1;
            }
            mid = (int)((lo+hi)/2);
        }
        return mid;
    }
}