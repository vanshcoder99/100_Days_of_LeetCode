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



// Maximum Units on a Truck
class Solution {
    public int maximumUnits(int[][] btypes, int ts) {
        int n = btypes.length;
        Arrays.sort(btypes,(a,b) -> {
            if(a[1] == b[1]) return Integer.compare(a[0],b[0]);
            return Integer.compare(b[1],a[1]);
        });

        long res = 0;        
        int i = 0;
        while(i<n && ts != 0){
            if(ts-btypes[i][0]>= 0){
                ts-=btypes[i][0];
                res+=(btypes[i][0] * btypes[i][1]);
            }
            else if(ts>0){
                res+=(ts * btypes[i][1]);
                ts = 0;
                break;
            }
            i++;
        }

        return (int)res;
    }
}
