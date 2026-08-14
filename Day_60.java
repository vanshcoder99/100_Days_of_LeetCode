// Frequency of the Most Frequent Element
class Solution {
    public int maxFrequency(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int cnt = 0, l = 0;
        long sum = 0;
        for(int r=0;r<n;r++){
            sum+=nums[r];
            while((long)(nums[r]) * (r-l+1) > sum + k){
                sum-=nums[l];
                l++;
            }
            cnt = Math.max(cnt,r-l+1);
        }
        return cnt;
    }
}
