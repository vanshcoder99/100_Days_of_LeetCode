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
