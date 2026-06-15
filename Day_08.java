// Best Time to Buy and Sell Stock
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n == 1) return 0;
        int ans = 0, mini = prices[0];
        for(int i=1;i<n;i++){
            mini = Math.min(mini,prices[i]);
            if(mini<prices[i]){
                int net = prices[i] - mini;
                ans = Math.max(ans,net);
            }
        }
        return ans;
    }
}
