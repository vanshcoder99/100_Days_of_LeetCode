// Directed Graph Cycle
class Solution {
    public boolean dfs(int node,boolean[] vis,boolean[] pathVis,List<List<Integer>> adj) {
        vis[node] = true;
        pathVis[node] = true;
        for(var it : adj.get(node)){
            if(pathVis[it]) return true;
            else if(!vis[it]){
                if(dfs(it,vis,pathVis,adj)) return true;
            }
        }
        pathVis[node] = false;
        return false;
    }
    public boolean isCyclic(int V, int[][] edges) {
        int n = edges.length;
        if(n == 0) return false;
        int m = edges[0].length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(var it : edges){
            adj.get(it[0]).add(it[1]);
        }
        
        boolean vis[] = new boolean[V];
        boolean pathVis[] = new boolean[V];
        
        for(int i=0;i<V;i++){
            if(dfs(i,vis,pathVis,adj)) return true;
        }
        return false;
    }
}



// Find Eventual Safe States
class Solution {
    public boolean dfs(int node,boolean[] vis,boolean[] pathVis,boolean[] check,int[][] adj) {
        vis[node] = true;
        pathVis[node] = true;
        for(var it : adj[node]){
            if(pathVis[it]) return true;
            else if(!vis[it]){
                if(dfs(it,vis,pathVis,check,adj)) return true;
            }
        }
        pathVis[node] = false;
        check[node] = true;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        List<Integer> ans = new ArrayList<>();
        boolean[] vis = new boolean[V];
        boolean[] pathVis = new boolean[V];
        boolean[] check = new boolean[V];
        for(int i=0;i<V;i++){
            if(!vis[i]){
                dfs(i,vis,pathVis,check,graph);
            }
        }
        for(int i=0;i<V;i++){
            if(check[i]){
                ans.add(i);
            }
        }
        return ans;
    }
}



//  Is Graph Bipartite?
class Solution {
    public boolean dfs(int node,int[] color,int[][] adj) {
        for(var it : adj[node]){
            if(color[it] == color[node]) return false;
            else if(color[it] == -1){
                color[it] = 1 - color[node];
                if(!dfs(it,color,adj))  return false;
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int[] color = new int[V];
        Arrays.fill(color,-1);
        for(int i=0;i<V;i++){
            if(color[i] == -1){
                color[i] = 0;
                if(!dfs(i,color,graph)) return false;
            }
        }
        return true;
    } 
}


// Topological Sort
class Solution {
    public void dfs(int node,boolean[] vis,Stack<Integer> st,List<List<Integer>> adj){
        vis[node] = true;
        for(var it : adj.get(node)){
            if(!vis[it]){
                dfs(it,vis,st,adj);
            }
        }
        st.push(node);
    }
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        ArrayList<Integer> ans = new ArrayList<>();
        int n = edges.length;
        if(n == 0) return ans;
        int m = edges[0].length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(var it : edges){
            adj.get(it[0]).add(it[1]);
        }
        
        boolean[] vis = new boolean[V];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<V;i++){
            if(!vis[i]){
                dfs(i,vis,st,adj);
            }
        }
        
        while(!st.isEmpty()){
            ans.add(st.pop());
        }
        return ans;
    }
}
