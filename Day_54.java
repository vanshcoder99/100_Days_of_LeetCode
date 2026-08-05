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

// Count Hills and Valleys in an Array
class Solution {
    public int countHillValley(int[] nums) {
        int n = nums.length;
        int i = 1,cnt=0;
        while(i<n-1){
            int curr = nums[i];
            int prev = nums[i-1];
            if(curr == prev){
                i++;
                continue;
            }
            int j = i+1;
            while(j<n-1){
                if(curr == nums[j]) j++;
                else break;
            }
            i = j;
            if((prev>curr && nums[j]>curr) || (prev<curr && nums[j]<curr)) cnt++;
        }

        return cnt;
    }
}
