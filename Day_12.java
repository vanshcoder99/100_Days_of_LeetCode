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

// Missing And Repeating  --> GFG PRACTICE PROBLEM
class Solution {
    ArrayList<Integer> findTwoElement(int arr[]) {
        int n = arr.length;
        long s = 0, s2 = 0;
        long sn = ((long)n*(n+1))/2;
        long s2n = ((long)n*(n+1)*(2*n+1))/6;
        for(int i=0;i<n;i++){
            s+=arr[i];
            s2+= ((long)arr[i]*(long)arr[i]);
        }
        
        long val1 = sn - s;
        long val2 = s2n - s2;
        
        val2 = val2/val1;
        long x = (val1+val2)/2;
        long y = x - val1;
        return new ArrayList<>(Arrays.asList((int)y,(int)x));
    }
}

