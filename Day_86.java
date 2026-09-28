// 72. Edit Distance
class Solution {
    public int func(int i, int j,String w1, String w2,int[][] dp) {
        if(i<0 && j<0) return 0;
        if(i<0 && j>=0) return j+1;
        if(i>=0 && j<0) return i+1;
        if(dp[i][j] != -1) return dp[i][j];
        if(w1.charAt(i) == w2.charAt(j)) return dp[i][j] = func(i-1,j-1,w1,w2,dp);
        return dp[i][j] = 1 + Math.min(func(i-1,j,w1,w2,dp),Math.min(func(i-1,j-1,w1,w2,dp),func(i,j-1,w1,w2,dp)));
    }
    public int minDistance(String w1, String w2) {
        int n = w1.length(), m = w2.length();
        int[][] dp = new int[n][m];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        return func(n-1,m-1,w1,w2,dp);
    }
}
