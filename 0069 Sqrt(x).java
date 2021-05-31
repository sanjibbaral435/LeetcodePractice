// Newton's method

// Time O(n)

class Solution {
    public int mySqrt(int x) {
        if(x == 0 || x==1) return x;
        int left = 0;
        int right = x;

        // this will be a finite loop since result is must
        while(true){
            int mid = left + (right-left)/2;

            if(mid > x/mid){
                // mid^2 >x
                right = mid-1;
            } else {
                if (mid + 1 > x/(mid + 1))
                    return mid;
                left = mid + 1;
            }
        }
    }
}
