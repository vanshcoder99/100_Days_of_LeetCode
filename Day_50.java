// Sort an Array
class Solution {
    public void heapifyDown(int[] nums, int ind, int last){
        int lchild = 2*ind+1, rchild = 2*ind+2, largest = ind;
        if(lchild<=last && nums[lchild]>nums[largest]) largest = lchild;
        if(rchild<=last && nums[rchild]>nums[largest]) largest = rchild;
        if(largest != ind){
            int temp = nums[ind];
            nums[ind] = nums[largest];
            nums[largest] = temp;
            heapifyDown(nums,largest,last);
        }
    }
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        for(int i=n/2 - 1; i>=0; i--){
            heapifyDown(nums,i,n-1);
        }

        int last = n - 1;
        while(last > 0){
            int temp = nums[last];
            nums[last] = nums[0];
            nums[0] = temp;
            last--;
            if(last>0){
                heapifyDown(nums,0,last);
            }
        }
        return nums;
    }
}
