// 139. Word Break
class Solution {
    public boolean func(int i,int n,String s,Set<String> st,int[] dp) {
        if(i>=n) return true;
        if(dp[i] != -1) return dp[i] == 1;
        boolean ans = false;
        for(int idx=i;idx<n;idx++){
            if(st.contains(s.substring(i,idx+1))){
                ans = func(idx+1,n,s,st,dp);
                if(ans){
                    dp[i] = ans ? 1 : 0;
                    return ans;
                }                
            }
        }
        dp[i] = ans ? 1 : 0;
        return ans;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        Set<String> st = new HashSet<>(wordDict);
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return func(0,n,s,st,dp);
    }
}
