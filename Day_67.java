// Largest Perimeter Triangle
class Solution {
    public int largestPerimeter(int[] nums) {
        int n = nums.length;
        int pm = 0;
        Arrays.sort(nums);
        for(int i=n-1;i>=2;i--){
            int j=i-1, k = i-2;
            if(j>=0 && k>=0){
                int val1 = nums[i],val2 = nums[j], val3 = nums[k];
                if(val1+val2>val3 && val1+val3>val2 && val2+val3>val1){
                    pm = val1 + val2 + val3;
                    break;
                }
            }
            else break;
        }
        return pm;
    }
}
