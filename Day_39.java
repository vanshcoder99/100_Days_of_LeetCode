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



// Number of Sub-arrays of Size K and Average Greater than or Equal to Threshold
class Solution {
    public int numOfSubarrays(int[] arr, int k, int th) {
        int n = arr.length,sum=0,cnt=0;
        for(int i=0;i<k;i++){
            sum+=arr[i];
        }
        if(sum/k >= th) cnt++;
        for(int i=k;i<n;i++){
            sum = sum - arr[i-k] + arr[i];
            if(sum/k >= th) cnt++;
        }
        return cnt;
    }
}


// K Radius Subarray Averages
class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans,-1);
        if(2*k+1>n) return ans;
        if(k==0) return nums;
        long sum = 0;
        for(int i=0;i<2*k+1;i++){
            sum+=nums[i];
        }
        for(int i=k;i<n-k;i++){
            ans[i] = (int)(sum/(2*k+1));
            if(i==n-k-1) break;
            sum-=nums[i-k];
            sum+=nums[i+k+1];
        }
        return ans;
    }
}
