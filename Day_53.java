// Dijkstra Algorithm
class Pair{
    int nd, wt;
    Pair(int n, int w){
        nd = n;
        wt = w;
    }
    
}
class Solution {
    public ArrayList<Integer> dijkstra(int V, int[][] edges, int src) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
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
        
        int[] dist = new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src] = 0;
        pq.offer(new int[]{0,src});
        
        while(!pq.isEmpty()){
            int[] arr = pq.poll();
            int dis = arr[0];
            int node = arr[1];
            if(dis > dist[node]) continue;
            for(Pair it : adj.get(node)){
                int adjnode = it.nd;
                int wt = it.wt;
                if(dis + wt < dist[adjnode]){
                    dist[adjnode] = dis + wt;
                    pq.offer(new int[]{dist[adjnode],adjnode});
                }
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<V;i++){
            ans.add(dist[i]);
        }
        return ans;
    }
}
