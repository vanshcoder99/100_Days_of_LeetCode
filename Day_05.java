// Flood Fill
class Solution {
    public void dfs(int[][] image, int sr, int sc, int color,int val) {
        image[sr][sc] = color;
        int n = image.length;
        int m = image[0].length;
        for(int i=0;i<2;i++){
            int nrow = (i%2==0) ? sr + 1 : sr - 1;
            int ncol = (i%2==0) ? sc + 1 : sc - 1;
            if(nrow >= 0 && nrow < n && image[nrow][sc] == val){
                dfs(image,nrow,sc,color,val);
            }
            if(ncol>= 0 && ncol < m && image[sr][ncol] == val){
                dfs(image,sr,ncol,color,val);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        int val = image[sr][sc];
        if(val == color) return image;
        dfs(image,sr,sc,color,val);
        return image;
    }
}

// Pow(x, n)
class Solution {
    public double pow(double x, long n){
        if(n == 0) return 1;
        if(n == 1) return x;
        if(n % 2 == 0) return pow(x*x,n/2);
        return x * pow(x,n-1);
    }
    public double myPow(double x, int n) {
        long num = n;
        if(num<0) return 1/pow(x,-num);
        return pow(x,num);
    }
}
