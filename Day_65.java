// Longest Subarray of 1's After Deleting One Element
class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int size = 0, l = 0, zcnt = 0;
        for(int r=0;r<n;r++){
            while(zcnt > 1){
                if(nums[l] == 0) zcnt--;
                l++;
            }
            if(nums[r] == 0) zcnt++;
            if(zcnt == 1) size = Math.max(size,r-l);
        }
        if(size == 0 && zcnt == 0) return n - 1;
        return size;
    }
}




// 1695. Maximum Erasure Value
class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        HashSet<Integer> st = new HashSet<>();
        int l = 0, sum = 0, maxsum = 0;
        for(int r=0;r<n;r++){
            int val = nums[r];
            while(st.contains(val)){
                st.remove(nums[l]);
                sum-=nums[l];
                l++;
            }
            sum+=val;
            st.add(val);
            maxsum = Math.max(maxsum,sum);
        }
        return maxsum;
    }
}
