// Lemonade Change
class Solution {
    public boolean lemonadeChange(int[] bills) {
        int n = bills.length;
        int cntf = 0, cntt = 0;
        for(int i=0;i<n;i++){
            int bill = bills[i];
            if(bill == 5) cntf++;
            else if(bill == 10){
                if(cntf == 0) return false;
                cntf--;
                cntt++;
            }
            else{
                if(cntf > 0 && cntt > 0){
                    cntf--;
                    cntt--;
                }
                else if(cntf >= 3) cntf-=3;
                else return false;
            }
        }
        return true;
    }
}


// Shortest Job First
class Solution {
    static int solve(int bt[]) {
        int n = bt.length;
        Arrays.sort(bt);
        int twt = 0, wt = 0;
        for(int i=1;i<n;i++){
            wt+=bt[i-1];
            twt+=wt;
        }
        return (twt/n);
    }
}



// Longest Harmonious Subsequence
class Solution {
    public int findLHS(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int l = 0,maxlen = 0,min=nums[0],max=nums[0];
        for(int r=1;r<n;r++){
            max=nums[r];
            if(min == max) continue;
            while((l<r) && (max-min) != 1){
                l++;
                min = nums[l];
            }
            if(max-min == 1)maxlen = Math.max(maxlen,r-l+1);
        }
        return maxlen;
    }
}



// class Solution {
    public int arrayPairSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int sum = 0;
        for(int i=0;i<n;i+=2){
            sum+=nums[i];
        }
        return sum;
    }
}
