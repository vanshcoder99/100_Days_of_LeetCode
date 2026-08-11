// Path With Minimum Effort
class Tuple{
    int diff, row, col;
    Tuple(int d, int r, int c){
        diff = d;
        row = r;
        col = c;
    }
}
class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        int[] delrow = {-1,0,1,0};
        int[] delcol = {0,1,0,-1};
        int[][] mingrid = new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(mingrid[i],(int)1e9);
        }
        mingrid[0][0] = 0;
        PriorityQueue<Tuple> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.diff,b.diff));
        pq.offer(new Tuple(0,0,0));

        while(!pq.isEmpty()){
            Tuple t = pq.poll();
            int diff = t.diff;
            int r = t.row;
            int c = t.col;
            if(r == n-1 && c == m-1) return diff;
            for(int i=0;i<4;i++){
                int nr = r + delrow[i];
                int nc = c + delcol[i];
                if(nr>=0 && nr<n && nc>=0 && nc<m){
                    int newdiff = Math.max(diff,Math.abs(heights[nr][nc]-heights[r][c]));
                    if(newdiff < mingrid[nr][nc]){
                        mingrid[nr][nc] = newdiff;
                        pq.offer(new Tuple(newdiff,nr,nc));
                    }
                }
            }
        }
        return -1;
    }
}
