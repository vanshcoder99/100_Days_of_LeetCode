// Alien Dictionary
class Solution {
    public String findOrder(String[] words) {
        int n = words.length;
        StringBuilder sb = new StringBuilder();
        int[] indegree = new int[26];
        boolean[] present = new boolean[26];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<26;i++){
            adj.add(new ArrayList<>());
        }
        for(int k=0;k<n-1;k++){
            int i = 0, j = 0;
            int len1 = words[k].length(), len2 = words[k+1].length();
            String s1 = words[k], s2 = words[k+1];
            while(i<len1 && j<len2){
                if(s1.charAt(i) != s2.charAt(j)){
                    adj.get(s1.charAt(i)-'a').add(s2.charAt(j)-'a');
                    indegree[s2.charAt(j)-'a']++;
                    break;
                }
                i++;
                j++;
            }
            if(i == len2 && len1>len2) return "";
        }
        
        for(int i=0;i<n;i++){
            for(var it : words[i].toCharArray()){
                present[it-'a'] = true;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        int chcnt = 0;
        for(int i=0;i<26;i++){
            if(present[i]){
                chcnt++;
                if(indegree[i] == 0) q.offer(i);
            }
        }
        
        while(!q.isEmpty()){
            int node = q.poll();
            sb.append((char) (node+'a'));
            for(var it : adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0) q.offer(it);
            }
        }
        
        if(sb.length() < chcnt) return "";
        return sb.toString();
    }
}
