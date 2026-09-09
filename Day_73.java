// Best Time to Buy and Sell Stock III
class Solution {
    public int func(int i,int buy,int cnt,int[] arr,int[][][] dp) {
        if(i == arr.length || cnt == 2) return 0;
        if(dp[i][buy][cnt] != -1) return dp[i][buy][cnt];
        int price = 0;
        if(buy == 1){
            price = Math.max((-1)*arr[i] + func(i+1,0,cnt,arr,dp),0 + func(i+1,1,cnt,arr,dp));
        }
        else{
            price = Math.max(arr[i] + func(i+1,1,cnt+1,arr,dp),0 + func(i+1,0,cnt,arr,dp));
        }
        return dp[i][buy][cnt] = price;
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][3];
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return func(0,1,0,prices,dp);
    }
}




// Best Time to Buy and Sell Stock IV
class Solution {
    public int func(int i,int buy,int cnt,int[] arr, int[][][] dp) {
        if(i == arr.length || cnt == 0) return 0;
        if(dp[i][buy][cnt] != -1) return dp[i][buy][cnt];
        int price = 0;
        if(buy == 1){
            price = Math.max((-1)*arr[i] +func(i+1,0,cnt,arr,dp),0+func(i+1,1,cnt,arr,dp));
        }
        else{
            price = Math.max(arr[i] + func(i+1,1,cnt-1,arr,dp),0+func(i+1,0,cnt,arr,dp));
        }
        return dp[i][buy][cnt] = price;
    }
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][k+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return func(0,1,k,prices,dp);
    }
}
