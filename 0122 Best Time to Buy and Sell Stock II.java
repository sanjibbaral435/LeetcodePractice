// we can simply go on crawling over the slope and keep on adding the profit obtained from every consecutive transaction

class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
		}		
        int total = 0;
	    for (int i = 1; i<prices.length; i++){
	    	if (prices[i] > prices[i-1]) {
	    	    total += prices[i] - prices[i-1] ;
	    	}
	    }	     
	    return total;
    }
}