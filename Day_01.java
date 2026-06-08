// Two Sum 
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> mpp = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int leftsum = target - nums[i];
            if(mpp.containsKey(leftsum)) return new int[]{mpp.get(leftsum),i};
            mpp.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }
}
