// 1547. Minimum Cost to Cut a Stick
class Solution {
    public int func(int i, int j,int arr[],int[][] dp) {
        if(i>j) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int mincost = Integer.MAX_VALUE;
        for(int idx = i;idx<=j;idx++){
            int cost = (arr[j+1] - arr[i-1]) + func(i,idx-1,arr,dp) + func(idx+1,j,arr,dp);
            mincost = Math.min(mincost,cost);
        }
        return dp[i][j] = mincost;
    }
    public int minCost(int n, int[] cuts) {
        int size = cuts.length;
        int[] arr = new int[size+2];
        arr[size+1] = n;
        for(int i=0;i<size;i++) arr[i+1] = cuts[i];
        Arrays.sort(arr);
        int[][] dp = new int[size+1][size+1];
        for(int i=0;i<=size;i++) Arrays.fill(dp[i],-1);
        return func(1,size,arr,dp);
    }
}
