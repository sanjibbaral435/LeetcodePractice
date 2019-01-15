class Solution {
    public int countPrimes(int n) {
        boolean[] isComposite = new boolean[n];
        int count = 0;
        for(int i=2; i< n; i++){
            if(!isComposite[i]){
                int k = 2;
                while(k*i < n){
                    isComposite[k*i] = true;
                    k++;
                }
                count++;
            }
        }
        return count;
    }
}