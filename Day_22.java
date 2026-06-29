// Reverse Pairs
class Solution {
    public int merge(int low,int mid,int high,int[] nums){
        int cnt = 0;
        int left = low, right = mid + 1;
        int i = low, j = mid + 1;
        List<Integer> temp = new ArrayList<>();
        while(left<=mid && right<=high){
            if(nums[left]<=nums[right]){
                temp.add(nums[left++]);
            }
            else{
                temp.add(nums[right++]);
            }
        } 
        while(left<=mid) temp.add(nums[left++]);
        while(right<=high) temp.add(nums[right++]);
        while(i<=mid && j<=high){
            if((long)nums[i]>2*(long)nums[j]){
                cnt+=(mid-i+1);
                j++;
            }
            else{
                i++;
            }
        }
        for(i=low;i<=high;i++){
            nums[i] = temp.get(i-low);
        }
        return cnt;
    }

    public int mergesort(int low,int high,int[] nums){
        int cnt = 0;
        if(low>=high) return cnt;
        int mid = low - (low-high)/2;
        cnt+=mergesort(low,mid,nums);
        cnt+=mergesort(mid+1,high,nums);
        cnt+=merge(low,mid,high,nums);
        return cnt;
    }
    public int reversePairs(int[] nums) {
        int n = nums.length;
        return mergesort(0,n-1,nums);
    }
}
