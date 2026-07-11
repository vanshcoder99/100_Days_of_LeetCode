// Leetcode 3095 Shortest Subarray With OR at Least K I
class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int minlen = Integer.MAX_VALUE, n = nums.length;
        for(int i=0;i<n;i++){
            int or = 0;
            for(int j=i;j<n;j++){
                or|=nums[j];
                if(or >= k){
                    minlen = Math.min(minlen,j-i+1);
                }
            }
        }
        return (minlen != Integer.MAX_VALUE) ? minlen : -1;
    }
}



// Count the Number of Beautiful Subarrays
class Solution {
    public long beautifulSubarrays(int[] nums) {
        int n = nums.length,prexor = 0;
        long cnt = 0;
        Map<Integer,Integer> mpp = new HashMap<>();
        mpp.put(0,1);
        for(int i=0;i<n;i++){
            prexor = prexor ^ nums[i];
            if(mpp.containsKey(prexor)) cnt += mpp.get(prexor);
            mpp.put(prexor,mpp.getOrDefault(prexor,0)+1);
        }
        return cnt;
    }
}



//Maximum XOR for Each Query
class Solution {
    public int[] getMaximumXor(int[] nums, int maxBit) {
        int n = nums.length, maxxor = (int)Math.pow(2,maxBit)-1;
        int[] prexor = new int[n];
        prexor[0] = nums[0];
        for(int i=1;i<n;i++){
            prexor[i] = prexor[i-1] ^ nums[i];
        }
        int i = 0, j = n-1;
        while(i<=j){
            int temp = prexor[i];
            prexor[i] = prexor[j] ^ maxxor;
            prexor[j] = temp ^ maxxor;
            i++;
            j--;
        }
        
        return prexor;
    }
}
