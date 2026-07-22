// Task Scheduler
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int size = tasks.length;
        int[] freq = new int[26];
        for(int i=0;i<size;i++){
            freq[tasks[i] - 'A']++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
        for(int i=0;i<26;i++){
            if(freq[i] != 0){
                pq.offer(freq[i]);
            }
        }
        int cnt = 0;
        while(!pq.isEmpty()){
            int tcycle = 0;
            int cycle = n+1;
            List<Integer> list = new ArrayList<>();
            while(cycle > 0 && !pq.isEmpty()){
                int currtask = pq.poll();
                if(currtask>1) list.add(currtask - 1);
                tcycle++;
                cycle--;
            }
            for(int it : list){
                pq.offer(it);
            }
            cnt += pq.isEmpty() ? tcycle : n+1;
        }
        return cnt;
    }
}
