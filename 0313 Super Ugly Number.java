// Extension of 264 Ugly Number Problem

class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        if(n==0) return 0;
        if(n==1) return 1;
        
        int len = primes.length;
        
        int[] primes_index = new int[len];
        int[] next_primes = new int[len];
        
        for(int j=0; j<len; j++){
            next_primes[j] = primes[j];
        }        
        
        int ugly[] = new int[n];
        ugly[0] = 1;
        
        for(int i=1; i<n; i++){
            int next_ugly = getMin(next_primes);
            ugly[i] = next_ugly; 
            
            for(int j=0; j<len; j++){
                if(next_ugly == next_primes[j]){
                    primes_index[j]++;
                    next_primes[j] = primes[j]*ugly[primes_index[j]];
                }
            }
            
        }
        return ugly[n-1];
    }
    
    public int getMin(int[] numbers){
        int minValue = numbers[0];
        for(int i=1;i<numbers.length;i++){
            if(numbers[i] < minValue){
                minValue = numbers[i];
            }
        }
        return minValue;
    }
}
