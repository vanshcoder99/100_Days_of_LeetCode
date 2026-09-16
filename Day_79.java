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
