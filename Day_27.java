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
