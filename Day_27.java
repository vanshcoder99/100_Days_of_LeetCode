// Container With Most Water
class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int maxi = 0;
        int l = 0, r = n - 1;
        while(l<r){
            int area = 1;
            if(height[l]>=height[r]){
                area = height[r] * (r-l);
                r--;
            }
            else{
                area = height[l] * (r-l);
                l++;
            }
            maxi = Math.max(maxi,area);
        }
        return maxi;
    }
}



// Trapping Rain Water
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int l = 0, r = n - 1, lmax = 0, rmax = 0;
        int total = 0;
        while(l<r){
            if(height[l]>=height[r]){
                if(height[r]>rmax) rmax = height[r];
                else total += (rmax - height[r]);
                r--;
            }
            else{
                if(height[l]>lmax) lmax = height[l];
                else total+=(lmax-height[l]);
                l++;
            }
        }
        return total;
    }
}
