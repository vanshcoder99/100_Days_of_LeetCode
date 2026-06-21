// Subsets
class Solution {
    public void func(int i,int n, int[] nums,List<Integer> list,List<List<Integer>> ans){
        if(i == n){
            ans.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[i]);
        func(i+1,n,nums,list,ans);
        list.remove(list.size()-1);
        func(i+1,n,nums,list,ans);
    }
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        func(0,n,nums,list,ans);
        return ans;
    }
}
