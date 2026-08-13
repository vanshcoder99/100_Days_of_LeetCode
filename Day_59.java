// Apple Redistribution into Boxes
class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int n = apple.length, m = capacity.length;
        int sum = 0;
        Arrays.sort(capacity);
        for(int i=0;i<n;i++){
            sum+=apple[i];
        }
        int cnt = 0;
        for(int i=m-1;i>=0;i--){
            sum-= capacity[i];
            cnt++;
            if(sum <= 0) break;
        }

        return cnt;
    }
}



// Maximize Sum Of Array After K Negations
class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            if(k == 0) break;
            if(nums[i] < 0){
                nums[i] = - nums[i];
                k--;
            }
        }
        int sum = 0, min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            min = Math.min(min,nums[i]);
        }
        if(k % 2 == 0) return sum;
        sum = sum - (2*min);
        return sum;
    }
}
