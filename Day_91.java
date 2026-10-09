// 132. Palindrome Partitioning II
class Solution {
    public boolean ispalindrome(int i,int j,String s) {
        while(i<j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
    public int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        for(int i=n-1;i>=0;i--){
            int mincost = Integer.MAX_VALUE;
            for(int j=i;j<n;j++){
                if(ispalindrome(i,j,s)){
                    int cost = 1 + dp[j+1];
                    mincost = Math.min(mincost,cost);
                }
            }
            dp[i] = mincost;
        }
        return dp[0]-1;
    }
}




// 1043. Partition Array for Maximum Sum
class Solution {
    public int func(int i,int k,int[] arr,int[] dp) {
        int n = arr.length;
        if(i == n) return 0;
        if(dp[i] != -1) return dp[i];
        int maxi = Integer.MIN_VALUE;
        int maxval = Integer.MIN_VALUE;
        for(int idx=i;idx<i+k && idx<n;idx++){
            maxval = Math.max(maxval,arr[idx]);
            int cost = maxval*(idx-i+1) + func(idx+1,k,arr,dp);
            maxi = Math.max(maxi,cost);
        }
        return dp[i] = maxi;
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return func(0,k,arr,dp);
    }
}
