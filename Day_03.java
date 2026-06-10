// Number of Islands
class Pair{
    int first;
    int second;
    Pair(int f, int s){
        this.first = f;
        this.second = s;
    }
}
class Solution {
    public void bfs(int r, int c, char[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        grid[r][c] = '0';
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(r,c));
        while(!q.isEmpty()){
            Pair p = q.poll();
            int row = p.first;
            int col = p.second;
            
            for(int i=0;i<2;i++){
                int nrow = (i%2==0) ? row+1 : row-1;
                int ncol = (i%2==0) ? col+1 : col-1;
                if(ncol>=0 && ncol<m  && grid[row][ncol] == '1'){
                    grid[row][ncol] = '0';
                    q.offer(new Pair(row,ncol));
                }
                if(nrow>=0 && nrow<n && grid[nrow][col] == '1'){
                    grid[nrow][col] = '0';
                    q.offer(new Pair(nrow,col));
                }
            }
        }
    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int cnt = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == '1'){
                    cnt++;
                    bfs(i,j,grid);
                }
            }
        }
        return cnt;
    }
}


// Merge Sorted Array
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n == 0) return;
        int i = m-1, j = n - 1, k = m + n - 1;
        while(i>=0 && j>=0){
            if(nums1[i] > nums2[j]){
                nums1[k] = nums1[i];
                nums1[i] = 0;
                k--;
                i--;
            }
            else{
                nums1[k] = nums2[j];
                k--;
                j--;
            }
        }
        while(j>=0 && k>=0){
            nums1[k--] = nums2[j--];
        }

    }
}


// Next Permutation
class Solution {
    public void reverse(int[] nums,int i, int j){
        while(i<j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int ind = -1;
        for(int i=n-2;i>=0;i--){
            if(nums[i] < nums[i+1]){
                ind = i;
                break;
            }
        }
        if(ind == -1){
            reverse(nums,0,n-1);
            return;
        }

        int i = n-1;
        while(i>ind){
            if(nums[ind]<nums[i]){
                int temp = nums[ind];
                nums[ind] = nums[i];
                nums[i] = temp;
                break;
            }
            i--;
        }

        reverse(nums,ind+1,n-1);

    }
}
