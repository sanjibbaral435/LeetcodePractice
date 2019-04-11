class Solution {
    public int threeSumMulti(int[] A, int target) {
        int MOD = 1000000000 + 7;
        Arrays.sort(A);
        long ans = 0;
        
        for(int i=0; i<A.length; i++){
            int sum = target - A[i];
            
            int j = i+1;
            int k = A.length -1;
            
            while(j < k){
                if(A[j] + A[k] > sum){
                    k--;
                } else if(A[j] + A[k] < sum){
                    j++;
                } else if (A[j] != A[k]) {  
                    // We have A[j] + A[k] == T.
                    // Let's count "left": the number of A[j] == A[j+1] == A[j+2] == ...
                    // And similarly for "right".
                    int left = 1, right = 1;
                    while (j+1 < k && A[j] == A[j+1]) {
                        left++;
                        j++;
                    }
                    while (k-1 > j && A[k] == A[k-1]) {
                        right++;
                        k--;
                    }

                    ans += left * right;
                    ans %= MOD;
                    j++;
                    k--;
                } else {
                    // M = k - j + 1
                    // We contributed M * (M-1) / 2 pairs.
                    ans += (k-j+1) * (k-j) / 2;
                    ans %= MOD;
                    break;
                }
            }
        }
        
        return (int)ans;
    }
}
