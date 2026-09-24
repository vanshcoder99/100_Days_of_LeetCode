// 983. Minimum Cost For Tickets
class Solution {
    public int func(int i,int n,int[] days, int[] costs,int[] dp) {
        if(i == n) return 0;
        if(dp[i] != -1) return dp[i];
        int opt1 = costs[0] + func(i+1,n,days,costs,dp);
        
        int idx = i;
        while(idx<n && days[idx] < days[i] + 7) idx++;
        int opt2 = costs[1] + func(idx,n,days,costs,dp);

        idx = i;
        while(idx<n && days[idx] < days[i] + 30) idx++;
        int opt3 = costs[2] + func(idx,n,days,costs,dp);

        return dp[i] = Math.min(opt1,Math.min(opt2,opt3));
    }
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return func(0,n,days,costs,dp);
    }
}
