// Shortest Path in Unweighted Graph
class Solution {
    public int shortestPath(int V, int[][] edges, int src, int dest) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(var it : edges){
            int u = it[0];
            int v = it[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        int[] dist = new int[V];
        Arrays.fill(dist,(int)1e9);
        dist[src] = 0;
        
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        while(!q.isEmpty()){
            int node = q.poll();
            for(var it : adj.get(node)){
                if(dist[node] + 1 < dist[it]){
                    dist[it] = dist[node] + 1;
                    q.offer(it);
                }
            }
        }
        
        for(int i=0;i<V;i++){
            if(dist[i] == (int)1e9) dist[i] = -1;
        }
        return dist[dest];
    }
}
