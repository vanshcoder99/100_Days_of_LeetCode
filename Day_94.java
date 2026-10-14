// 852. Peak Index in a Mountain Array
class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        int low = 1, high = n-2;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid-1]<arr[mid] && arr[mid]>arr[mid+1]) return mid;
            else if(arr[mid-1]>arr[mid]) high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }
}




// 1552. Magnetic Force Between Two Balls
class Solution {
    public boolean func(int[] nums, int maxe,int m) {
        int balls = 1,i=1,j=0;
        while(i<nums.length){
            if(nums[i]-nums[j] >= maxe){
                balls++;
                j=i;
            }
            i++;
        }
        if(balls >= m) return true;
        return false;
    }
    public int maxDistance(int[] nums, int m) {
        int n = nums.length;
        Arrays.sort(nums);
        int maxi = nums[0],mini = nums[0];
        for(int i=1;i<n;i++){
            int val = nums[i];
            maxi = Math.max(maxi,val);
            mini = Math.min(mini,val);
        }
        int low = 1, high = maxi-mini;
        while(low<=high){
            int mid = low + (high-low)/2;
            boolean valid = func(nums,mid,m);
            if(valid) low = mid + 1;
            else high = mid - 1;
        }
        return high;
    }
}
