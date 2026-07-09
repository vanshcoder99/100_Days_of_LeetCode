// Group Anagrams
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        int n = strs.length;
        if(n == 0) return ans;
        HashMap<String,List<String>> mpp = new HashMap<>();
        for(int i=0;i<n;i++){
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            String s = new String(arr);
            if(mpp.containsKey(s)){
                mpp.get(s).add(strs[i]);
            }
            else{
                mpp.put(s,new ArrayList<>(Arrays.asList(strs[i])));
            }
        }
        for(var it : mpp.values()){
            ans.add(it);
        }
        return ans;       
    }
}
