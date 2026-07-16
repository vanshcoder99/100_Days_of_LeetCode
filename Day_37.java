// Contiguous Array
class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int maxlen = 0, presum = 0;
        Map<Integer,Integer> mpp = new HashMap<>();
        for(int i=0;i<n;i++){
            presum = (nums[i] == 0) ? presum-1 : presum+1;
            if(presum == 0) maxlen = Math.max(maxlen,i+1);
            else{
                if(mpp.containsKey(presum)){
                    int idx = mpp.get(presum);
                    maxlen = Math.max(maxlen,i-idx);
                }
                else mpp.put(presum,i);
            }
        }
        return maxlen;ā
    }
}



// Subarray Sums Divisible by K
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        int cnt = 0,presum=0;
        Map<Integer,Integer> mpp = new HashMap<>();
        mpp.put(0,1);
        for(int i=0;i<n;i++){
            presum+=nums[i];
            int rem = presum%k;
            if(rem<0) rem+=k;
            if(mpp.containsKey(rem)){
                cnt+=mpp.get(rem);
            }
            mpp.put(rem,mpp.getOrDefault(rem,0)+1);
        }
        return cnt;
    }
}


// Continuous Subarray Sum
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        int presum = 0;
        Map<Integer,Integer> mpp = new HashMap<>();
        for(int i=0;i<n;i++){
            presum+=nums[i];
            int rem = presum % k;
            if(rem == 0){
                if(i+1 >= 2) return true;
            }
            if(mpp.containsKey(rem)){
                int idx = mpp.get(rem);
                if(i-idx>=2) return true;
            }
            else mpp.put(rem,i);
        }
        return false;
    }
}
