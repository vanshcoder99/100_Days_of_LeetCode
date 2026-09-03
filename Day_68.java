// Frog Jump
class Solution {
    int minCost(int[] height) {
        int n = height.length;
        int prev = 0, prev2 = 0;
        for(int i=1;i<n;i++){
            int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
            left = prev + Math.abs(height[i]-height[i-1]);
            if(i>1) right = prev2 + Math.abs(height[i]-height[i-2]);
            int curri = Math.min(left,right);
            prev2 = prev;
            prev = curri;
        }
        return prev;
    }
}
