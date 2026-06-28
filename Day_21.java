// 01 Matrix
class Pair{
    int first,second,third;
    Pair(int f, int s, int t){
        this.first = f;
        this.second = s;
        this.third = t;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] ans = new int[n][m];
        Queue<Pair> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j] == 0){
                    q.offer(new Pair(i,j,0));
                }
            }
        }
        int[] delrow = {-1,0,1,0};
        int[] delcol = {0,1,0,-1};
        while(!q.isEmpty()){
            Pair p = q.poll();
            int r = p.first;
            int c = p.second;
            int t = p.third;
            for(int i=0;i<4;i++){
                int nr = r + delrow[i];
                int nc = c + delcol[i];
                if(nr>=0 && nr<n && nc>=0 && nc<m && mat[nr][nc] == 1){
                    mat[nr][nc] = 0;
                    int val = t + 1;
                    ans[nr][nc] = val;
                    q.offer(new Pair(nr,nc,val));
                }
            }
        }

        return ans;
    }
}
