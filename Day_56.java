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
