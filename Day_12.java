// Merge Intervals
class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if(n == 1) return intervals;
        Arrays.sort(intervals,(a,b) -> a[0] - b[0]);
        List<int[]> ans = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int i=1;i<n;i++){
            int x = intervals[i][0];
            int y = intervals[i][1];
            if(end>=x) end = Math.max(end,y);
            else{
                ans.add(new int[]{start,end});
                start = x;
                end = y;
            }
        }
        ans.add(new int[]{start,end});
        int size = ans.size();
        int[][] res = new int[size][2];
        for(int i=0;i<size;i++){
            res[i] = ans.get(i);
        }
        return res;
    }
}
