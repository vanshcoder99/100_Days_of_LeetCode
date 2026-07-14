// Job Sequencing Problem
class Solution {
    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        int n = profit.length;
        int[][] arr = new int[n][2];
        for(int i=0;i<n;i++){
            arr[i][0] = deadline[i];
            arr[i][1] = profit[i];
        }
        Arrays.sort(arr,(a,b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<n;i++){
            int[] job = arr[i];
            if(job[0] > pq.size()) pq.offer(job[1]);
            else if(!pq.isEmpty() && job[1] > pq.peek()){
                pq.poll();
                pq.offer(job[1]);
            }
        }
        
        int p = 0, c = pq.size();
        for(var it : pq){
            p+=it;
        }
        
        return new ArrayList<>(Arrays.asList(c,p));
    }
}



// Maximum Meetings in One Room
class Solution {
    public ArrayList<Integer> maxMeetings(int[] s, int[] f) {
        int n = s.length;
        int[][] arr = new int[n][3];
        for(int i=0;i<n;i++){
            arr[i] = new int[]{s[i],f[i],i+1};
        }
        Arrays.sort(arr,(a,b) -> a[1] - b[1]);
        ArrayList<Integer> list = new ArrayList<>();
        int ed = arr[0][1];
        list.add(arr[0][2]);
        for(int i=1;i<n;i++){
            if(arr[i][0] > ed){
                list.add(arr[i][2]);
                ed = arr[i][1];
            }
        }
        Collections.sort(list);
        return list;
    }
}
