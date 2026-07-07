// Alien Dictionary
class Solution {
    public String findOrder(String[] words) {
        int n = words.length;
        StringBuilder sb = new StringBuilder();
        int[] indegree = new int[26];
        boolean[] present = new boolean[26];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<26;i++){
            adj.add(new ArrayList<>());
        }
        for(int k=0;k<n-1;k++){
            int i = 0, j = 0;
            int len1 = words[k].length(), len2 = words[k+1].length();
            String s1 = words[k], s2 = words[k+1];
            while(i<len1 && j<len2){
                if(s1.charAt(i) != s2.charAt(j)){
                    adj.get(s1.charAt(i)-'a').add(s2.charAt(j)-'a');
                    indegree[s2.charAt(j)-'a']++;
                    break;
                }
                i++;
                j++;
            }
            if(i == len2 && len1>len2) return "";
        }
        
        for(int i=0;i<n;i++){
            for(var it : words[i].toCharArray()){
                present[it-'a'] = true;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        int chcnt = 0;
        for(int i=0;i<26;i++){
            if(present[i]){
                chcnt++;
                if(indegree[i] == 0) q.offer(i);
            }
        }
        
        while(!q.isEmpty()){
            int node = q.poll();
            sb.append((char) (node+'a'));
            for(var it : adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0) q.offer(it);
            }
        }
        
        if(sb.length() < chcnt) return "";
        return sb.toString();
    }
}



// Longest Subarray with Sum K
class Solution {
    public int longestSubarray(int[] nums, int k) {
        int n = nums.length;
        if(n == 0) return 0;
        Map<Integer,Integer> mpp = new HashMap<>();
        int presum = 0, maxlen = 0; 
        for(int i=0;i<n;i++){
            presum+=nums[i];
            if(presum == k) maxlen = Math.max(maxlen,i+1);
            else{
                if(mpp.containsKey(presum-k)){
                    int idx = mpp.get(presum-k);
                    maxlen = Math.max(maxlen,i-idx);
                }
            }
            if(!mpp.containsKey(presum)) mpp.put(presum,i);
        }
        return maxlen;
    }
}



// Subarray Sum Equals K
class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int cnt = 0, presum = 0;
        HashMap<Integer,Integer> mpp = new HashMap<>();
        mpp.put(0,1);
        for(int i=0;i<n;i++){
            presum+=nums[i];
            if(mpp.containsKey(presum-k)) cnt+=mpp.get(presum-k);
            mpp.put(presum,mpp.getOrDefault(presum,0)+1);
        }
        return cnt;
    }
}
