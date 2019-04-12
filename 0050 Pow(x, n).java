class Solution {
    public double myPow(double x, int n) {
        if(n < 0){
            return fastPow(1/x, -n);
        }
        return fastPow(x, n);
    }
    
    public double fastPow(double x, int n){
        if(n == 0)
            return 1.0;
        double res = fastPow(x, n/2);
        if(n%2 == 0)
            return res * res;
        else
            return res * res * x;
    }
}
