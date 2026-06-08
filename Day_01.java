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


// Sort Colors --> Using Dutch National Flag Algorithm
class Solution {
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void sortColors(int[] nums) {
        int n = nums.length;
        int low = 0, mid = 0, high = n - 1;
        while(mid<=high){
            if(nums[mid] == 0){
                swap(nums,low,mid);
                low++;
                mid++;
            }
            else if(nums[mid] == 1){
                mid++;
            }
            else{
                swap(nums,mid,high);
                high--;
            }
        }
    }
}


// Pascal's Triangle
class Solution {
    public List<Integer> rowgenerate(int n){
        List<Integer> list = new ArrayList<>();
        int ans = 1;
        list.add(ans);
        for(int i=0;i<n;i++){
            ans = (ans*(n-i))/(i+1);
            list.add(ans);
        }
        return list;
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<numRows;i++){
            ans.add(rowgenerate(i));
        }
        return ans;
    }
}
