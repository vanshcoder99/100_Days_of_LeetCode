// Best Time to Buy and Sell Stock
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n == 1) return 0;
        int ans = 0, mini = prices[0];
        for(int i=1;i<n;i++){
            mini = Math.min(mini,prices[i]);
            if(mini<prices[i]){
                int net = prices[i] - mini;
                ans = Math.max(ans,net);
            }
        }
        return ans;
    }
}


// Find All Duplicates in an Array
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        if(n == 1) return ans;
        for(int i=0;i<n;i++){
            int idx = Math.abs(nums[i]) - 1;
            if(nums[idx] < 0) ans.add(Math.abs(nums[i]));
            else nums[idx] = - nums[idx];
        }
        return ans;
    }
}
