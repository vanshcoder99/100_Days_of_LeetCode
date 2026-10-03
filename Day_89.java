// 807. Max Increase to Keep City Skyline
class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length;
        int row[] = new int[n];
        int col[] = new int[n];
        for(int r=0;r<n;r++){
            int rm = grid[r][0];
            int cm = grid[0][r];
            for(int c=0;c<n;c++){
                rm = Math.max(rm,grid[r][c]);
                cm = Math.max(cm,grid[c][r]);
            }
            row[r] = rm;
            col[r] = cm;
        }
        int sum = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                sum+=(Math.min(row[i],col[j]) - grid[i][j]);
            }
        }
        return sum;
    }
}



// 646. Maximum Length of Pair Chain
class Solution {
    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        Arrays.sort(pairs,(a,b) -> Integer.compare(a[1],b[1]));
        int i = 0,j=1,cnt=1;
        while(j<n){
            if(pairs[i][1] < pairs[j][0]){
                i = j;
                j++;
                cnt++;
            }
            else j++;
        }
        return cnt;
    }
}
