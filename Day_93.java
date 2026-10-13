// 541. Reverse String II
class Solution {
    public String reverseStr(String s, int k) {
        int n = s.length();
        if(k>n) return new StringBuilder(s).reverse().toString();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i<n){
            if(i%(2*k) == 0){
                int val = i+k;
                if(val >= n) val = n;
                sb.append(new StringBuilder(s.substring(i,val)).reverse());
                i+=k;
            }
            if(i<n){
                sb.append(s.charAt(i));
            }
            i++;
        }
        
        return sb.toString();
    }
}




// 1011. Capacity To Ship Packages Within D Days
class Solution {
    public int getDays(int[] nums,int cap) {
        int n = nums.length;
        int x = 0,days=1;
        for(int i=0;i<n;i++){
            if(nums[i] > cap){
                days = (int)1e9;
                return days;
            }
            if(x+nums[i]<=cap){
                x+=nums[i];
            }
            else{
                x = nums[i];
                days++;
            }
        }
        return days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int sum = 0;
        for(int i=0;i<n;i++) sum+=weights[i];
        int low = 1, high = sum;
        System.out.println(getDays(weights,2));
        while(low<=high){
            int mid = low + (high-low)/2;
            int d = getDays(weights,mid);
            if(d<=days) high = mid - 1;
            else low = mid + 1;
        }
        return low;
    }
}
