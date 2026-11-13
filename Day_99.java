// 2220. Minimum Bit Flips to Convert Number
class Solution {
    public int minBitFlips(int start, int goal) {
        int n = start ^ goal;
        int cnt = 0;
        while(n != 0){
            if((n & 1) == 1) cnt++;
            n = n >> 1;
        }
        return cnt;
    }
}
