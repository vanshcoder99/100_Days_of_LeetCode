// Rotting Oranges
class Pair{
    int first, second,third;
    Pair(int f, int s, int t){
        first = f;
        second = s;
        third = t;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int freshes = 0;
        Queue<Pair> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 2) q.offer(new Pair(i,j,0));
                else if(grid[i][j] == 1) freshes++;
            }
        }
        if(freshes == 0) return 0;
        int minute = 0;
        int[] delrow = {-1,0,1,0};
        int[] delcol = {0,1,0,-1};
        while(!q.isEmpty()){
            Pair p = q.poll();
            int row = p.first;
            int col = p.second;
            int time = p.third;
            minute = Math.max(minute,time);
            for(int i=0;i<4;i++){
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == 1){
                    grid[nrow][ncol] = 2;
                    freshes--;
                    q.offer(new Pair(nrow,ncol,time+1));
                }
            }
        }
        if(freshes != 0) return -1;
        return minute;
    }
}

// Delete Node in a Linked List
class Solution {
    public void deleteNode(ListNode node) {
        if(node == null) return;
        ListNode nextnode = node.next;
        node.val = nextnode.val;
        node.next = node.next.next;
    }
}
