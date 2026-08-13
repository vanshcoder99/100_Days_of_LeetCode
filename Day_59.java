// Apple Redistribution into Boxes
class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int n = apple.length, m = capacity.length;
        int sum = 0;
        Arrays.sort(capacity);
        for(int i=0;i<n;i++){
            sum+=apple[i];
        }
        int cnt = 0;
        for(int i=m-1;i>=0;i--){
            sum-= capacity[i];
            cnt++;
            if(sum <= 0) break;
        }

        return cnt;
    }
}
