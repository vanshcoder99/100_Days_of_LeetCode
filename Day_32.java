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
