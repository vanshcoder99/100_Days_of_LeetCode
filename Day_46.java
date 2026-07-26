// Shortest Palindrome
class Solution {
    public String shortestPalindrome(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder(s).reverse();
        String rev = sb.toString();
        String str = s + "$" + rev;
        int size = str.length(), len = 0, i = 1;
        int[] lps = new int[size];
        while(i<size){
            if(str.charAt(len) == str.charAt(i)){
                len++;
                lps[i] = len;
                i++;
            }
            else{
                if(len != 0){
                    len = lps[len-1];
                }
                else{
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return rev.substring(0,rev.length()-lps[size-1]) + s;
    }
}
