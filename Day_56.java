// Remove Outermost Parentheses
class Solution {
    public String removeOuterParentheses(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        int op = 0, cl = 0, i = 0;
        for(int j=0;j<n;j++){
            if(s.charAt(j) == '(') op++;
            else cl++;
            if(op == cl){
                sb.append(s.substring(i+1,j));
                i = j + 1;
                op = 0;
                cl = 0;
            }
        }
        return sb.toString();
    }
}



// Smallest distinct window
class Solution {
    public int findSubString(String str) {
        int n = str.length();
        int mcnt = Integer.MAX_VALUE, l = 0,cnt = 0;
        Set<Character> st = new HashSet<>();
        for(int i=0;i<n;i++){
            st.add(str.charAt(i));
        }
        int ucnt = st.size();
        int[] freq = new int[26];
        
        for(int r=0;r<n;r++){
            char ch = str.charAt(r);
            if(freq[ch-'a'] == 0) cnt++;
            freq[ch-'a']++;
            if(ucnt == cnt) mcnt = Math.min(mcnt,r-l+1);
            while(ucnt == cnt &&freq[str.charAt(l)-'a']>1){
                freq[str.charAt(l)-'a']--;
                l++;
                mcnt = Math.min(mcnt,r-l+1);
            }
        }
        
        return mcnt;
    }
}
