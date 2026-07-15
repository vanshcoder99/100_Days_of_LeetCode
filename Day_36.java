// Subarrays with K Different Integers
class Solution {
    public int atmost(int[] nums, int k){
        int n = nums.length;
        int cnt = 0, l = 0;
        Map<Integer,Integer> mpp = new HashMap<>();
        for(int r=0;r<n;r++){
            mpp.put(nums[r],mpp.getOrDefault(nums[r],0)+1);
            while(mpp.size()>k){
                int val = nums[l];
                int freq = mpp.get(val) - 1;
                if(freq == 0) mpp.remove(val);
                else mpp.put(val,freq);
                l++;
            }
            cnt+=(r-l+1);
        }
        return cnt;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atmost(nums,k) - atmost(nums,k-1);        
    }
}



// Count Subarrays With Score Less Than K
class Solution {
    public long countSubarrays(int[] nums, long k) {
        int n = nums.length, l = 0;
        long cnt = 0, sum = 0;
        for(int r=0;r<n;r++){
            sum+=nums[r];
            while(sum * (r-l+1) >= k){
                sum-=nums[l];
                l++;
            }
            cnt+=(r-l+1);
        }
        return cnt;
    }
}
