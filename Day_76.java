// Coin Change
class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] prev = new int[amount+1];

        for(int amt=1;amt<=amount;amt++){
            if(amt % coins[0] == 0) prev[amt] = amt / coins[0];
            else prev[amt] = (int)1e9; 
        }
        
        for(int i=1;i<n;i++){
            int[] curr = new int[amount+1];
            for(int amt=1;amt<=amount;amt++){
                int nottake = prev[amt];
                int take = (int)1e9;
                if(coins[i]<=amt) take = 1 + curr[amt-coins[i]];
                curr[amt] = Math.min(nottake,take);
            }
            prev = curr;
        }
        if(prev[amount] >= (int)1e9) return -1;
        return prev[amount];
    }
}
