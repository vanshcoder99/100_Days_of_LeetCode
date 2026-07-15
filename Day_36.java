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
