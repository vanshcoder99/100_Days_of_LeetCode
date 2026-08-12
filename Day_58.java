// Shortest Path in an Undirected Graph
class Pair{
    int node;
    int wt;
    Pair(int n, int w){
        node = n;
        wt = w;
    }
}
class Solution {
    public ArrayList<Integer> shortestPath(int V, int[][] edges, int src, int dest) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<=V;i++){
            adj.add(new ArrayList<>());
        }
        for(var it : edges){
            int u = it[0];
            int v = it[1];
            int w = it[2];
            adj.get(u).add(new Pair(v,w));
            adj.get(v).add(new Pair(u,w));
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0],b[0]));
        pq.offer(new int[]{0,dest});
        int[] dist = new int[V+1];
        Arrays.fill(dist,(int)1e9);
        dist[dest] = 0;
        
        while(!pq.isEmpty()){
            int[] arr = pq.poll();
            int d = arr[0];
            int node = arr[1];
            if(d > dist[node]) continue;
            for(Pair it : adj.get(node)){
                int adjnode = it.node;
                int adjwt = it.wt;
                if(adjwt + d < dist[adjnode]){
                    dist[adjnode] = adjwt + d;
                    pq.offer(new int[]{dist[adjnode],adjnode});
                }
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        if(dist[src] == (int)1e9){
            ans.add(-1);
            return ans;
        }
        
        int node = src;
        
        while(node != dest ){
            ans.add(node);
            int mini = Integer.MAX_VALUE;
            for(Pair it : adj.get(node)){
                int adjnode = it.node;
                int adjwt = it.wt;
                if(dist[node] == dist[adjnode] + adjwt){
                    mini = Math.min(mini,adjnode);
                }
            }
            if(mini == Integer.MAX_VALUE) {
                return new ArrayList<>(Arrays.asList(-1));
            }
            node = mini;
        }
        
        ans.add(dest);
        return ans;
    }
}
