// Matrix Chain Multiplication
class Solution {
    static int func(int i,int j,int arr[],int[][] dp) {
        if(i == j) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int mini = Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int steps = func(i,k,arr,dp) + func(k+1,j,arr,dp) + (arr[i-1] * arr[k] * arr[j]);
            mini = Math.min(mini,steps);
        }
        return dp[i][j] = mini;
    }
    static int matrixMultiplication(int arr[]) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        return func(1,n-1,arr,dp);
    }
}
