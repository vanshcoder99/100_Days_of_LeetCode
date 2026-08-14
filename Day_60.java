// Frequency of the Most Frequent Element
class Solution {
    public int maxFrequency(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int cnt = 0, l = 0;
        long sum = 0;
        for(int r=0;r<n;r++){
            sum+=nums[r];
            while((long)(nums[r]) * (r-l+1) > sum + k){
                sum-=nums[l];
                l++;
            }
            cnt = Math.max(cnt,r-l+1);
        }
        return cnt;
    }
}


// Smallest Missing Integer Greater Than Sequential Prefix Sum
class Solution {
    public int missingInteger(int[] nums) {
        int n = nums.length;
        int sum = nums[0];
        for(int i=1;i<n;i++){
            if(nums[i] - 1 == nums[i-1]){
                sum+=nums[i];
            }
            else break;
        }
        Set<Integer> st = new HashSet<>();
        for(int it : nums){
            st.add(it);
        }
        while(true){
            if(st.contains(sum)) sum++;
            else break;
        }
        return sum;
    }
}
