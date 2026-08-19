// Word Ladder II
class Solution {
  public List<List<String>> findSequences(String beginWord, String endWord, List<String> wordList) {
    List<List<String>> ans = new ArrayList<>();
    Set<String> st = new HashSet<>(wordList);
    if (!st.contains(endWord)) return ans;
    Queue<List<String>> q = new LinkedList<>();
    q.offer(new ArrayList<>(Arrays.asList(beginWord)));
    st.remove(beginWord);
    Set<String> todel = new HashSet<>();
    while(!q.isEmpty()){
        int size = q.size();
        for(int i=0;i<size;i++){
            List<String> list = q.poll();
            String s = list.get(list.size()-1);
            if(s.equals(endWord)){
                if(ans.isEmpty()) ans.add(new ArrayList<>(list)); 
                else if(ans.get(ans.size()-1).size() == list.size()) ans.add(new ArrayList<>(list));
            }

            for(int j=0;j<s.length();j++){
                char original = s.charAt(j);
                StringBuilder sb = new StringBuilder(s);
                for(char ch='a';ch<='z';ch++){
                    sb.setCharAt(j,ch);
                    String str = sb.toString();
                    if(st.contains(str)){
                        list.add(str);
                        q.add(new ArrayList<>(list));
                        todel.add(str);
                        list.remove(list.size()-1);
                    }
                }
            }        
        }
        for(var it : todel) st.remove(it);
        todel.clear();
        if(!ans.isEmpty()) break;
    }
    return ans;
  }
}
