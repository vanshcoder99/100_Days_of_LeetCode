// Maximum Subarray --> using kadane's algorithm
class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0, maxi = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            maxi = Math.max(maxi,sum);
            if(sum<0) sum = 0;
        }
        return maxi;
    }
}


// Search a 2D Matrix --> using binary search 
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int low = 0, high = (n*m)-1;
        while(low<=high){
            int mid = low - ((low-high)/2);
            int val = matrix[mid/m][mid%m];
            if(val == target) return true;
            else if(val>target) high=mid-1;
            else low=mid+1;
        }
        return false;
    }
}

