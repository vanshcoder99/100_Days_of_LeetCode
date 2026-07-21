// Find the Index of the First Occurrence in a String
class Solution {
    public int strStr(String haystack, String needle) {
        int hl = haystack.length();
        int nl = needle.length();
        if(nl > hl) return -1;
        for(int i=0;i<=hl-nl;i++){
            if(haystack.substring(i,i+nl).equals(needle)){
                return i;
            }
        }                
        return -1;  
    }
}



// Boats to Save People
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int n = people.length, cnt=0;
        int l = 0,r=n-1;
        while(l<=r){
            if(people[r] + people[l] <= limit){
                cnt++;
                r--;
                l++;
            }
            else if(people[r]<=limit){
                cnt++;
                r--;
            }
        }
        return cnt;
    }
}
