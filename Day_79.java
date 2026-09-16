// Longest Bitonic Subsequence
class Solution {
    public int longestBitonicSequence(int n,int[] nums) {
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        Arrays.fill(dp1,1);
        Arrays.fill(dp2,1);
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i] > nums[j]){
                    int val = dp1[j] + 1;
                    if(dp1[i] < val) dp1[i] = val;
                }
            }
        }
        int mval = 0;
        for(int i=n-1;i>=0;i--){
            for(int j=n-1;j>i;j--){
                if(nums[i] > nums[j]){
                    int val = dp2[j] + 1;
                    if(dp2[i] < val) dp2[i] = val;
                }
            }
            if(dp1[i] > 1 && dp2[i] > 1) mval = Math.max(mval,dp1[i]+dp2[i]-1);
        }
        return mval;
    }
}




// 1143. Longest Common Subsequence
class Solution {
    public int func(int i,int j,String t1, String t2,int[][] dp) {
        if(i<0 || j<0) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(t1.charAt(i) == t2.charAt(j)) return dp[i][j] = 1 + func(i-1,j-1,t1,t2,dp);
        return dp[i][j] = Math.max(func(i,j-1,t1,t2,dp),func(i-1,j,t1,t2,dp));
    }
    public int longestCommonSubsequence(String t1, String t2) {
        int n1 = t1.length(), n2 = t2.length();
        int[][] dp = new int[n1][n2];
        for(int i=0;i<n1;i++) Arrays.fill(dp[i],-1);
        return func(n1-1,n2-1,t1,t2,dp);
    }
}
