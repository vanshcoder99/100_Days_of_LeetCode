// 962. Maximum Width Ramp
class Solution {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int width = 0;
        for(int i=0;i<n;i++){
            if(st.isEmpty() || (nums[i] < nums[st.peek()])) st.push(i);
        }
        for(int j=n-1;j>=0;j--){
            while(!st.isEmpty() && nums[j] >= nums[st.peek()]){
                width = Math.max(width,j-st.peek());
                st.pop();
            }
        }
        return width;
    }
}
