// Binary Subarrays With Sum
class Solution {
    public int atmost(int[] nums, int k) {
        if(k<0) return 0;
        int n = nums.length;
        int l = 0, sum = 0, cnt = 0;
        for(int r=0;r<n;r++){
            sum+=nums[r];
            while(sum>k){
                sum-=nums[l];
                l++;
            }
            cnt+=(r-l+1);
        }
        return cnt;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
        return atmost(nums,goal) - atmost(nums,goal-1);
    }
}



// Reverse Words in a String
class Solution {
    public String reverseWords(String s) {
        s = s.trim().replaceAll("\\s+"," ");
        String[] str = s.split(" ");
        int n = str.length;
        StringBuilder sb = new StringBuilder();
        for(int i=n-1;i>=0;i--){
            sb.append(str[i]);
            if(i != 0)sb.append(' ');
        }
        return sb.toString();
    }
}
