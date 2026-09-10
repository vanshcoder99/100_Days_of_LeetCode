// Subset Sum Problem
class Solution {
    static boolean func(int i,int target,int arr[],int[][] dp){
        if(target == 0) return true;
        if(i == 0) return arr[0] == target;
        if(dp[i][target] != -1) return dp[i][target] == 1;
        boolean nottake = func(i-1,target,arr,dp);
        boolean take = false;
        
        if(target>=arr[i]){
            take = func(i-1,target-arr[i],arr,dp);
        }
        
        dp[i][target] = take || nottake ? 1 : 0;
        
        return take || nottake;
    }
    static boolean isSubsetSum(int arr[], int target) {
        int n = arr.length;
        int[][] dp = new int[n][target+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return func(n-1,target,arr,dp);
    }
}
