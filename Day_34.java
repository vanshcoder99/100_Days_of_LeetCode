// Assign Cookies
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int n = g.length, m = s.length;
        int i = 0, j = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        while(i<n && j<m){
            if(s[j] >= g[i]) i++;
            j++;
        }
        return i;
    }
}



// Maximum Matching of Players With Trainers
class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        int n = players.length, m = trainers.length;
        Arrays.sort(players);
        Arrays.sort(trainers);
        int i=0, j=0;
        while(i<n && j<m){
            if(players[i]<=trainers[j]) i++;
            j++;
        }
        return i;
    }
}


// Non-overlapping Intervals
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> a[1]-b[1]);
        int cnt = 0,ed = intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            int[] it = intervals[i];
            if(ed <= it[0]) ed = it[1];
            else cnt++;
        }
        return cnt;
    }
}
