// Count Number of Nice Subarrays
class Solution {
    public int atmost(int[] nums, int k) {
        int n = nums.length;
        if(k<0) return 0;
        int odd = 0, cnt = 0,l=0;
        for(int r=0;r<n;r++){
            if(nums[r] % 2 == 1) odd++;
            while(odd>k){
                if(nums[l] % 2 == 1) odd--;
                l++;
            }
            cnt+=(r-l+1);
        }
        return cnt;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        return atmost(nums,k) - atmost(nums,k-1);
    }
}



// Find All Anagrams in a String
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int n = s.length(), m = p.length();
        List<Integer> ans = new ArrayList<>();
        if(m>n) return ans;
        int[] freqp = new int[26];
        int[] freqw = new int[26];
        for(int i=0;i<m;i++){
            freqp[p.charAt(i) -'a']++;
            freqw[s.charAt(i) -'a']++;
        }
        int st = 0;
        if(Arrays.equals(freqp,freqw)) ans.add(st);
        for(int i=m;i<n;i++){
            freqw[s.charAt(i-m)-'a']--;
            freqw[s.charAt(i)-'a']++;
            st++;
            if(Arrays.equals(freqp,freqw)) ans.add(st);
        }
        return ans;
    }
}
