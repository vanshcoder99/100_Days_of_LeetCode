// Shortest path in Directed Acyclic Graph
class Pair{
    int first, second;
    Pair(int f, int s){
        this.first = f;
        this.second = s;
    }
}
class Solution {
    public void dfs(int node, boolean[] vis,Stack<Integer> st,List<List<Pair>> adj){
        vis[node] = true;
        for(var it : adj.get(node)){
            int v = it.first;
            if(!vis[v]){
                dfs(v,vis,st,adj);
            }
        }
        st.push(node);
    }
    public int[] shortestPath(int N, int M, int[][] edges) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<N;i++){
            adj.add(new ArrayList<>());
        }
        for(var it : edges){
            adj.get(it[0]).add(new Pair(it[1],it[2]));
        }
        Stack<Integer> st = new Stack<>();
        boolean[] vis = new boolean[N];
        for(int i=0;i<N;i++){
            if(!vis[i]){
                dfs(i,vis,st,adj);
            }
        }

        int[] dis = new int[N];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[0] = 0;
        while(!st.isEmpty()){
            int node = st.pop();
            for(var it : adj.get(node)){
                int v =  it.first;
                int wt =  it.second;
                if(dis[node] != Integer.MAX_VALUE && dis[node] + wt < dis[v]){
                    dis[v] = dis[node] + wt;
                }
            }
        }

        for(int i=0;i<N;i++){
            if(dis[i] == Integer.MAX_VALUE) dis[i] = -1;
        }
        return dis;
    }
}



// Zigzag Conversion
class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        int n = s.length();
        StringBuilder[] str = new StringBuilder[numRows];
        for(int i=0;i<numRows;i++){
            str[i] = new StringBuilder();
        }
        int cr = 0;
        boolean dirn = true;
        for(int i=0;i<n;i++){
            str[cr].append(s.charAt(i));
            if(dirn) cr++;
            else cr--;
            if(cr == 0 || cr == numRows - 1) dirn = !dirn;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<numRows;i++){
            sb.append(str[i]);
        }

        return sb.toString();
        
    }
}



// Maximum Sub Array
class Solution {
    public ArrayList<Integer> findSubarray(int nums[]) {
        int n = nums.length;
        ArrayList<Integer> ans = new ArrayList<>();
        int ansst = -1, ansed = -1, start = -1, maxi = 0, sum = 0,maxlen=0;
        for(int i=0;i<n;i++){
            int val = nums[i];
            if(val<0){
                sum = 0;
                start = -1;
                continue;
            }
            if(start == -1) start = i;
            sum+=val;
            if(((i-start+1)>maxlen && sum>=maxi) || (sum > maxi)) {
                maxi = sum;
                ansst = start;
                ansed = i;
                maxlen = i - start + 1;
            }
        }
        
        
        ArrayList<Integer> list = new ArrayList<>();
        if(ansst == -1){
            list.add(-1);
            return list;
        }
        for(int i=ansst;i<=ansed;i++){
            list.add(nums[i]);
        }
        
        return list;
    }
}



// Count Subarrays with given XOR
class Solution {
    public long subarrayXor(int arr[], int k) {
        int n = arr.length;
        int prexor = 0;
        long cnt = 0;
        HashMap<Integer,Integer> mpp = new HashMap<>();
        mpp.put(0,1);
        for(int i=0;i<n;i++){
            prexor^=arr[i];
            if(mpp.containsKey(prexor^k)){
                cnt+=(long)mpp.get(prexor^k);
            }
            mpp.put(prexor,mpp.getOrDefault(prexor,0)+1);
        }
        return cnt;
    }
}



// Find Resultant Array After Removing Anagrams
class Solution {
    public boolean isAnagram(String[] words,int idx){
        int l1 = words[idx-1].length();
        int l2 = words[idx].length();
        if(l1 != l2) return false;
        int[] freq = new int[26];
        String s1 = words[idx];
        String s2 = words[idx-1];
        for(int i=0;i<l1;i++){
            freq[s1.charAt(i)-'a']++;
        }
        for(int i=0;i<l1;i++){
            freq[s2.charAt(i)-'a']--;
        }
        for(int i=0;i<26;i++){
            if(freq[i] != 0) return false;
        }
        return true;
    }
    public List<String> removeAnagrams(String[] words) {
        List<String> ans = new ArrayList<>();
        int n = words.length;
        ans.add(words[0]);
        for(int i=1;i<n;i++){
            if(!isAnagram(words,i)){
                ans.add(words[i]);
            }
        }

        return ans;
    }
}
