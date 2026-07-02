// Course Schedule II
class Solution {
    public int[] findOrder(int numc, int[][] pr) {
        int[] topo = new int[numc];
        int[] indeg = new int[numc];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numc;i++){
            adj.add(new ArrayList<>());
        }

        for(var it : pr){
            adj.get(it[1]).add(it[0]);
            indeg[it[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numc;i++){
            if(indeg[i] == 0) q.offer(i);
        }
        int i = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            topo[i++] = node;
            for(var it : adj.get(node)){
                indeg[it]--;
                if(indeg[it] == 0) q.offer(it);
            }
        }
        if(i<numc) return new int[]{};
        return topo;
    }
}
