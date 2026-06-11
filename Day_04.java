// Number of Provinces
class Solution {
    public void dfs(int node,int[][] isConnected,List<List<Integer>> adj,boolean[] vis){
        int n = isConnected.length;
        vis[node] = true;
        for(var it : adj.get(node)){
            if(!vis[it]){
                dfs(it,isConnected,adj,vis);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j] == 1 && i!=j){
                    adj.get(i).add(j);
                }
            }
        }
        int cnt = 0;
        boolean[] vis = new boolean[n];
        for(int i=0;i<n;i++){
            if(!vis[i]){
                cnt++;
                dfs(i,isConnected,adj,vis);
            }
        }
        return cnt;
    }
}
