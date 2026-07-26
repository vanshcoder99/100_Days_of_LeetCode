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



// Fruit Into Baskets
class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        if(n == 1) return 1;
        Map<Integer,Integer> mpp = new HashMap<>();
        int l = 0,maxcnt = 0;
        for(int r=0;r<n;r++){
            mpp.put(fruits[r],mpp.getOrDefault(fruits[r],0)+1);
            if(mpp.size()>2){
                int val = fruits[l];
                int freq = mpp.get(val);
                if(freq - 1 == 0) mpp.remove(val);
                else mpp.put(val,freq-1);
                l++;
            }
            if(mpp.size()<=2) maxcnt = Math.max(maxcnt,r-l+1);
        }
        return maxcnt;
    }
}
