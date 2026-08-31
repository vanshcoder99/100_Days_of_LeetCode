// Minimum Platforms
class Solution {
    public int minPlatform(int arr[], int dep[]) {
        int n = arr.length;
        Arrays.sort(arr);
        Arrays.sort(dep);
        int i = 0, j = 0,cnt=0,mcnt=0;
        while(i<n){
            if(arr[i]<=dep[j]){
                cnt++;
                i++;
                mcnt = Math.max(mcnt,cnt);
            }
            else{
                cnt--;
                j++;
            }
        }
        return mcnt;
    }
}
