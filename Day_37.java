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
