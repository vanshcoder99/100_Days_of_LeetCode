// Subarray Product Less Than K
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        int prod = 1, cnt = 0,l=0;
        for(int r=0;r<n;r++){
            prod*=nums[r];
            while(prod>=k){
                prod/=nums[l];
                l++;
            }
            cnt+=(r-l+1);
        }
        return cnt;
    }
}
