// Longest Substring With At Most K Distinct Characters
class Solution {
    public int kDistinctChar(String s, int k) {
        int n = s.length();
        int cnt = 0, l = 0;
        Map<Character,Integer> mpp = new HashMap<>();
        for(int r=0;r<n;r++){
            char ch = s.charAt(r);
            mpp.put(ch,mpp.getOrDefault(ch,0)+1);
            if(mpp.size()>k){
                char ch1 = s.charAt(l);
                int val = mpp.get(ch1) - 1;
                if(val == 0) mpp.remove(ch1);
                else mpp.put(ch1,val);
                l++;
            }
            if(mpp.size() <= k) cnt = Math.max(cnt,r-l+1);
        }
        return cnt;
    }
}
