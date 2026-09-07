// Minimum Falling Path Sum
class Solution {
    public int func(int i, int j,int[][] matrix,int[][] dp) {
        if(j<0 || j>=matrix[0].length) return (int)1e9;
        if(i == 0) return matrix[0][j];
        if(dp[i][j] != (int)1e4) return dp[i][j];
        int mini = Integer.MAX_VALUE;
        int val1 = matrix[i][j] + func(i-1,j,matrix,dp);        
        int val2 = matrix[i][j] + func(i-1,j-1,matrix,dp);        
        int val3 = matrix[i][j] + func(i-1,j+1,matrix,dp);    
        mini = Math.min(val1,Math.min(val2,val3));
        return dp[i][j] = mini;    
    }
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],(int)1e4);
        }
        int mini = Integer.MAX_VALUE;
        for(int j=0;j<n;j++){
            int sum = func(m-1,j,matrix,dp);
            mini = Math.min(mini,sum);
        }
        return mini;
    }
}
