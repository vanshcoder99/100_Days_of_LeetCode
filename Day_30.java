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



// Maximum Average Subarray I
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        int sum = 0, maxsum = Integer.MIN_VALUE;
        for(int i=0;i<k;i++){
            sum+=nums[i];
        }
        maxsum = Math.max(sum,maxsum); 
        for(int i=k;i<n;i++){
            sum = sum - nums[i-k] + nums[i];
            maxsum = Math.max(sum,maxsum); 
        }
        return (double)maxsum/k;
    }
}
