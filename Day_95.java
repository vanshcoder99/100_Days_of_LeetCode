// 1208. Get Equal Substrings Within Budget
class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        int l = 0, maxlen = 0, cost = 0;
        for(int r=0;r<n;r++){
            cost+=arr[r];
            if(cost>maxCost){
                cost-=arr[l];
                l++;
            }
            if(cost<=maxCost) maxlen = Math.max(maxlen,r-l+1);
        }
        return maxlen;
    }
}
