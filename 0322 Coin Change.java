// Dynamic Programming
// Recurrence relation min[i] = Minimum of (min[i - C_i]) for all denomatinations
// Time Complexity O(coins length*amount length)
// space complexity O(amount)
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] minCoin = new int[amount+1];
        Arrays.fill(minCoin, amount+1);  
        minCoin[0] = 0;
        for(int i = 1; i<=amount; i++){
            for(int j = 0; j<coins.length; j++){
                if(i >= coins[j]){
                    minCoin[i] = Math.min(minCoin[i], minCoin[i-coins[j]]+1);
                }
            }
        }
        return minCoin[amount] > amount ? -1 : minCoin[amount];
    }
}