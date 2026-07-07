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
