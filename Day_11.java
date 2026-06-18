//  Find All Numbers Disappeared in an Array
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            int idx = Math.abs(nums[i]) - 1;
            if(nums[idx] < 0) continue;
            else nums[idx] = - nums[idx];
        }
        for(int i=0;i<n;i++){
            if(nums[i] > 0) list.add(i+1);
        }
        return list;
    }
}


// Find the Duplicate Number
class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int slow = nums[0], fast = nums[0];
        while(true){
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(slow == fast) break;
        }
        fast = nums[0];
        while(slow != fast){
            fast = nums[fast];
            slow = nums[slow];
        }
        return fast;
    }
}
