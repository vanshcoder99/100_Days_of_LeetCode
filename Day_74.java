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




// Partition a set into two subsets with minimum absolute sum difference
class Solution {
    public boolean func(int i,int target,int[] arr,int[][] dp){
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
    public int minDifference(int[] arr) {
        int n = arr.length;
        if(n == 1) return arr[0];
        int sum = 0;
        for(int i=0;i<n;i++) sum+=arr[i];
        int[][] dp = new int[n][sum/2 + 1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        int diff = -1;
        for(int i=0;i<=sum/2;i++){
            int d = sum/2 -  i;
            if(func(n-1,d,arr,dp)){
                diff = (sum-d) - d;
                break;
            }
        }
        return diff;
    }
}
