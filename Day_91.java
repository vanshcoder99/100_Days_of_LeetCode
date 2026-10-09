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
