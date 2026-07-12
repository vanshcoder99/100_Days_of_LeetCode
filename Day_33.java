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
