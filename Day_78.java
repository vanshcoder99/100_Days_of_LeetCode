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
