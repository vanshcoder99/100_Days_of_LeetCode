// Remove Duplicates from Sorted Array
class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if(n == 1) return 1;
        int i = 0;
        for(int j=i+1;j<n;j++){
            if(nums[i]!=nums[j]){
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }
}

// Remove Duplicates from Sorted Array II
class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if(n == 1 || n == 2) return n;
        int i = 0, cnt = 1;
        for(int j=i+1;j<n;j++){
            if(nums[i] == nums[j]) cnt++;
            else if(nums[i] != nums[j]){
                if(cnt == 1){
                    i++;
                    nums[i] = nums[j];
                }
                else if(cnt>=2){
                    int val = nums[i];
                    i++;
                    nums[i++] = val;
                    nums[i] = nums[j];
                    cnt = 1;
                }
            }
        }
        if(cnt != 1){
            i++;
            nums[i] = nums[n-1];
        }
        return i+1;
    }
}
