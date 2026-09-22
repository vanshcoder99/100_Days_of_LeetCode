// 115. Distinct Subsequences
class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length(), m = t.length();
        int[] prev = new int[m+1];
        prev[0] = 1;

        for(int i=1;i<=n;i++){
            int[] curr = new int[m+1];
            curr[0] = 1;
            for(int j=1;j<=m;j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    curr[j] = prev[j-1] + prev[j]; 
                }
                else curr[j] = prev[j];
            }
            prev = curr;
        }
        return prev[m]; 
    }
}




// 583. Delete Operation for Two Strings
class Solution {
    public int func(int i,int j,String w1, String w2,int[][] dp) {
        if(i<0 || j<0) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(w1.charAt(i) == w2.charAt(j)) return dp[i][j] = 1 + func(i-1,j-1,w1,w2,dp);
        return dp[i][j] = Math.max(func(i-1,j,w1,w2,dp),func(i,j-1,w1,w2,dp));
    }
    public int minDistance(String w1, String w2) {
        int n = w1.length(), m = w2.length();
        int[][] dp = new int[n][m];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        return ((n + m) - 2*func(n-1,m-1,w1,w2,dp));
    }
}




// 712. Minimum ASCII Delete Sum for Two Strings
class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = (int)(s1.charAt(i-1)) + dp[i-1][j-1];
                }
                else dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        int val = dp[n][m], ascii = 0;
        for(int i=0;i<n;i++){
            ascii+=(int)(s1.charAt(i));
        }

        for(int j=0;j<m;j++){
            ascii+=(int)(s2.charAt(j));
        }
        return (ascii-2*val);
        
    }
}
