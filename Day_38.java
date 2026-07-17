// Binary Subarrays With Sum
class Solution {
    public int atmost(int[] nums, int k) {
        if(k<0) return 0;
        int n = nums.length;
        int l = 0, sum = 0, cnt = 0;
        for(int r=0;r<n;r++){
            sum+=nums[r];
            while(sum>k){
                sum-=nums[l];
                l++;
            }
            cnt+=(r-l+1);
        }
        return cnt;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
        return atmost(nums,goal) - atmost(nums,goal-1);
    }
}
