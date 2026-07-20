// Valid Parenthesis String
class Solution {
    public boolean checkValidString(String s) {
        int min = 0, max = 0;
        for(var ch : s.toCharArray()){
            if(ch == '('){
                min++;
                max++;
            }
            else if(ch == ')'){
                min--;
                max--;
            }
            else{
                min--;
                max++;
            }
            if(min<0) min = 0;
            if(max<0) return false;
        }
        return (min == 0);
    }
}


// Partition Labels
class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();
        int n = s.length();
        int[] last = new int[26];
        for(int i=0;i<n;i++){
            last[s.charAt(i)-'a'] = i;
        }
        int st = 0, end = 0;
        for(int i=0;i<n;i++){
            end = Math.max(end,last[s.charAt(i)-'a']);
            if(end == i){
                ans.add(end-st+1);
                st = end + 1;
            }
        }

        return ans;
    }
}
