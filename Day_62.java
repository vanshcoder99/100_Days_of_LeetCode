// Word Ladder
class Pair{
    String word;
    int level;
    Pair(String w, int l){
        word = w;
        level = l;
    }
}
class Solution {
    public int ladderLength(String bword, String eword, List<String> wlist) {
        int n = bword.length();
        int size = wlist.size();
        Set<String> st = new HashSet<>();
        for(int i=0;i<size;i++){
            st.add(wlist.get(i));
        }
        if(!st.contains(eword)) return 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(bword,1));
        if(st.contains(bword)) st.remove(bword);
        while(!q.isEmpty()){
            Pair p = q.poll();
            for(int i=0;i<n;i++){
                StringBuilder sb = new StringBuilder(p.word);
                char original = sb.charAt(i);
                for(char ch='a';ch<='z';ch++){
                    sb.setCharAt(i,ch);
                    String str = sb.toString();
                    if(str.equals(eword)) return p.level+1;
                    if(st.contains(str)){
                        q.offer(new Pair(str,p.level+1));
                        st.remove(str);
                    }
                    sb.setCharAt(i,original);
                }
            }
        }
        return 0;
    }
}
