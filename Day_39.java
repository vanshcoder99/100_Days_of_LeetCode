// Count Number of Nice Subarrays
class Solution {
    public int atmost(int[] nums, int k) {
        int n = nums.length;
        if(k<0) return 0;
        int odd = 0, cnt = 0,l=0;
        for(int r=0;r<n;r++){
            if(nums[r] % 2 == 1) odd++;
            while(odd>k){
                if(nums[l] % 2 == 1) odd--;
                l++;
            }
            cnt+=(r-l+1);
        }
        return cnt;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        return atmost(nums,k) - atmost(nums,k-1);
    }
}
