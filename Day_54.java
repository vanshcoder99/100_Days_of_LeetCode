// Minimum Subsequence in Non-Increasing Order
class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        int sum = 0, tsum = 0;
        for(int i=0;i<n;i++){
            tsum+=nums[i];
        }
        for(int i=n-1;i>=0;i--){
            sum+=nums[i];
            list.add(nums[i]);
            if(tsum-sum < sum) return list; 
        }
        return list;
    }
}
