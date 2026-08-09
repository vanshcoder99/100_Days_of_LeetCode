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



// Print Shortest Path
class Pair{
    int node;
    int wt;
    Pair(int nd,int w){
        node = nd;
        wt = w;
    }
}
class Solution {
    public List<Integer> shortestPath(int n, int m, int[][] edges) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++){
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
        int[] dist = new int[n+1];
        int[] parent = new int[n+1];

        Arrays.fill(dist,(int)1e9);
        dist[1] = 0;
        pq.offer(new int[]{0,1});

        for(int i=1;i<=n;i++){
            parent[i] = 1;
        }

        while(!pq.isEmpty()){
            int[] arr = pq.poll();
            int dis = arr[0];
            int node = arr[1];
            if(dis>dist[node]) continue;
            for(Pair it : adj.get(node)){
                int adjdis = it.wt;
                int adjnode = it.node;
                if(dis + adjdis < dist[adjnode]){
                    dist[adjnode] = dis + adjdis;
                    pq.offer(new int[]{dist[adjnode],adjnode});
                    parent[adjnode] = node;
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        if(dist[n] == (int)1e9){
            list.add(-1);
            return list;
        }
        int node = n;
        while(parent[node] != node){
            list.add(node);
            node = parent[node];
        }

        list.add(1);
        list.add(dist[n]);
        Collections.reverse(list);
        return list;
    }
}



