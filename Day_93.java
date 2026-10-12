// 541. Reverse String II
class Solution {
    public String reverseStr(String s, int k) {
        int n = s.length();
        if(k>n) return new StringBuilder(s).reverse().toString();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i<n){
            if(i%(2*k) == 0){
                int val = i+k;
                if(val >= n) val = n;
                sb.append(new StringBuilder(s.substring(i,val)).reverse());
                i+=k;
            }
            if(i<n){
                sb.append(s.charAt(i));
            }
            i++;
        }
        
        return sb.toString();
    }
}
