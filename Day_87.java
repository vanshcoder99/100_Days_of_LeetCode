// 64. Minimum Path Sum
class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[] prev = new int[m+1];
        Arrays.fill(prev,(int)1e9);
        for(int i=1;i<=n;i++){
            int[] curr = new int[m+1];
            curr[0] = (int)1e9;
            for(int j=1;j<=m;j++){
                if(i == 1 && j == 1){
                    curr[1] = grid[0][0];
                    continue;
                }
                curr[j] = grid[i-1][j-1] + Math.min(prev[j],curr[j-1]);
            }
            prev = curr;
        }
        return prev[m];
    }
}
