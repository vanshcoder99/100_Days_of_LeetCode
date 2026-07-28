// Longest Repeating Character Replacement
class Solution {
    public int longestSubstr(String s, int k) {
        int n = s.length();
        if(k>=n) return n;
        int[] hash = new int[26];
        int cnt = 0, maxfreq = 0, l = 0;
        for(int r=0;r<n;r++){
            char ch = s.charAt(r);
            hash[ch-'A']++;
            maxfreq = Math.max(maxfreq,hash[ch-'A']);
            if((r-l+1)- maxfreq > k){
                hash[s.charAt(l)-'A']--;
                l++;
            }
            if((r-l+1)- maxfreq <= k) cnt = Math.max(cnt,r-l+1);
        }
        return cnt;
    }
}
