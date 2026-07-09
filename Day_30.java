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


// Minimum Size Subarray Sum
class Solution {
    public int minSubArrayLen(int k, int[] nums) {
        int n = nums.length;
        int minlen = Integer.MAX_VALUE, sum = 0,l=0;
        for(int r=0;r<n;r++){
            sum+=nums[r];
            while(sum>=k && l<=r){
                minlen = Math.min(minlen,r-l+1);
                sum-=nums[l];
                l++;
            }
        }

        return (minlen != Integer.MAX_VALUE) ? minlen : 0;
    }
}



// Minimum Positive Sum Subarray 
class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();
        int minsum = Integer.MAX_VALUE, len = 0;
        for(int i=0;i<n;i++){
            int sum = 0;
            for(int j=i;j<n;j++){
                sum+=nums.get(j);
                len = j - i + 1;
                if(l<=len && len<=r && sum>0)  minsum = Math.min(minsum,sum);
            }
        }
        return (minsum!= Integer.MAX_VALUE) ? minsum : -1;
    }
}



// Maximum point you can obtain from cards
class Solution {
    public int maxScore(int[] cards, int k) {
        int n = cards.length;
        int sum = 0, maxsum = 0;
        for(int i=0;i<k;i++){
            sum+=cards[i];
        }
        maxsum = Math.max(maxsum,sum);
        for(int i=k-1;i>=0;i--){
            sum = sum - cards[i] + cards[n-k+i];
            maxsum = Math.max(maxsum,sum);
        }
        return maxsum;
    }
}
