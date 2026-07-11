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
