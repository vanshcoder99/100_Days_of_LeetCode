// Find Missing and Repeated Values
class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int N = n * n;
        long s = 0, s2 = 0;
        long sn = ((long) N * (N+1) ) / 2;
        long s2n = ((long) N * (N+1) * (2*N + 1) ) / 6;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                s+=grid[i][j];
                s2+= (long)grid[i][j] * (long)grid[i][j];
            }
        }
        long val1 = s - sn, val2 = s2 - s2n;
        val2 = val2/val1;
        long x  = (val1 + val2) / 2;
        long y = x - val1;
        return new int[]{(int)x,(int)y};
    }
}

// 3Sum
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<n-2;i++){
            if(i!=0 && nums[i] == nums[i-1]) continue;
            int j = i + 1;
            int k = n - 1;
            while(j<k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum > 0) k--;
                else if(sum<0) j++;
                else{
                    List<Integer> list = Arrays.asList(nums[i],nums[j],nums[k]);
                    ans.add(list);
                    j++;
                    k--;
                    while(j<k && nums[j] == nums[j-1]) j++;
                    while(j<k && nums[k] == nums[k+1]) k--;
                }
            }
        }
        return ans;
    }
}


// 4sum
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<n-3;i++){
            if(i!=0 && nums[i] == nums[i-1]) continue;
            for(int j=i+1;j<n-2;j++){
                if(j!=i+1 && nums[j] == nums[j-1]) continue;
                int l = j + 1;
                int k = n - 1;
                while(l<k){
                    long sum = (long)nums[i] + nums[j] + nums[k] + nums[l];
                    if(sum == target){
                        List<Integer> list = Arrays.asList(nums[i],nums[j],nums[l] ,nums[k]);
                        ans.add(list);
                        l++;
                        k--;
                        while(l<k && nums[l]==nums[l-1]) l++;
                        while(l<k && nums[k]==nums[k+1]) k--;
                    }
                    else if(sum>target) k--;
                    else l++;
                }
            }
        }
        return ans;
    }
}
