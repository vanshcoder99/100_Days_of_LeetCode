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


// Longest Substring with At Least K Repeating Characters
class Solution {
    public int func(String s, int k, int st, int end){
        if(end-st<k) return 0;
        int[] hash = new int[26];
        for(int i=st;i<end;i++){
            hash[s.charAt(i)-'a']++;
        }

        for(int i=st;i<end;i++){
            if(hash[s.charAt(i)-'a'] < k){
                int left = func(s,k,st,i);
                int right = func(s,k,i+1,end);
                return Math.max(left,right);
            }
        }
        return end-st;
    } 
    public int longestSubstring(String s, int k) {
        if(k>s.length()) return 0; 
        return func(s,k,0,s.length());
    }
}
