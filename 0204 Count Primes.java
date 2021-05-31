// Sieve of Eratosthenes
// Mark all non prime numbers by multiplication table

// Time O(sqrt(n)lognlogn)
// Space O(n)

class Solution {
    public int countPrimes(int n) {
        boolean[] isComposite = new boolean[n];
        int count = 0;

        for(int num=2; num<n; num++) {
            if(!isComposite[num]) {
                // prime num
                count++;
                int multiple = 2;
                while(multiple*num < n) {
                    isComposite[multiple*num] = true;
                    multiple++;
                }
            }
        }
        return count;
    }
}
