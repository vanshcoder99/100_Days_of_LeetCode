// 300. Longest Increasing Subsequence
class Solution {
    public int lowerbound(List<Integer> list,int x){
        int n = list.size();
        int low = 0,high = n-1,ans = n;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(list.get(mid)>=x){
                ans = mid;
                high = mid - 1;
            }
            else low = mid + 1;
        }
        return ans;
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        for(int i=1;i<n;i++){
            int val = nums[i];
            if(val>list.get(list.size()-1)) list.add(val);
            else{
                int idx = lowerbound(list,val);
                if(idx<list.size()) list.set(idx,val);
            }
        }
        return list.size();
    }
}




// Get Longest Increasing Subsequence
class Solution {
    public ArrayList<Integer> getLIS(int nums[]) {
       int n = nums.length;
       int[] dp = new int[n];
       int[] parent = new int[n];
       for(int i=0;i<n;i++){
           dp[i] = 1;
           parent[i] = i; 
       }
       for(int i=0;i<n;i++){
           for(int j=0;j<i;j++){
               if(nums[i]>nums[j]){
                   int val = 1 + dp[j];
                   if(dp[i] < val){
                       dp[i] = val;
                       parent[i] = j;
                   }
               }
           }
       }
       int stidx = -1,x = 0;
       for(int i=0;i<n;i++){
           if(x<dp[i]){
               x = dp[i];
               stidx = i;
           }
       }
       
       ArrayList<Integer> ans = new ArrayList<>();

       while(stidx != parent[stidx]){
           ans.add(nums[stidx]);
           stidx = parent[stidx];
       }
       ans.add(nums[stidx]);
       Collections.reverse(ans);
       return ans;
    }
}





// 368. Largest Divisible Subset
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<>();
        int[] dp = new int[n];
        int[] parent = new int[n];
        
        for(int i=0;i<n;i++){
            dp[i] = 1;
            parent[i] = i;
        }
        int midx = -1, mval = -1;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i] % nums[j] == 0 || nums[j] % nums[i] == 0){
                    int val = 1 + dp[j];
                    if(dp[i] < val){
                        dp[i] = val;
                        parent[i] = j;
                    }
                }
            }
            if(dp[i] > mval){
                midx = i;
                mval = dp[i];
            }
        }

        
        while(midx != parent[midx]){
            ans.add(nums[midx]);
            midx = parent[midx];
        }
        ans.add(nums[midx]);
        return ans;
    }
}
