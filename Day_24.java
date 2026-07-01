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
