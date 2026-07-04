// Maximum Subarray
class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int maxi = Integer.MIN_VALUE, sum = 0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            maxi = Math.max(maxi,sum);
            if(sum<0) sum = 0;
        }
        return maxi;
    }
}


// Contains Duplicate II
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer,Integer> mpp = new HashMap<>();
        for(int i=0;i<n;i++){
            if(mpp.containsKey(nums[i])){
                int val = mpp.get(nums[i]);
                if(Math.abs(val-i) <= k) return true;
            }
            mpp.put(nums[i],i);
        }
        return false;
    }
}
