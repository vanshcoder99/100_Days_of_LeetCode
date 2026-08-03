// Relative Ranks
class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] str = new String[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(b[0],a[0]));
        for(int i=0;i<n;i++){
            pq.offer(new int[]{score[i],i});
        }

        int k = 0;
        while(!pq.isEmpty()){
            int[] arr = pq.poll();
            int val = arr[1];
            k++;
            if(k <= 3){
                if(k == 1) str[val] = "Gold Medal";
                else if(k == 2) str[val] = "Silver Medal";
                else str[val] = "Bronze Medal";
            } 
            else{
                str[val] = k + ""; 
            }
        }

        return str;
    }
}
