// Construct String With Repeat Limit
class Solution {
    public String repeatLimitedString(String s, int rl) {
        int n = s.length();
        int[] freq = new int[26];
        PriorityQueue<Character> pq = new PriorityQueue<>((a,b) -> Character.compare(b,a));
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(freq[ch-'a'] == 0){
                pq.offer(ch);
            }
            freq[s.charAt(i)-'a']++;
        }

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            char ch = pq.poll();
            int min = Math.min(rl,freq[ch-'a']);
            freq[ch-'a']-=min;
            for(int i=0;i<min;i++){
                sb.append(ch);
            }
            if(pq.isEmpty()) break;
            if(freq[ch-'a'] == 0) continue;
            else{
                char ch1 = pq.peek();
                sb.append(ch1);
                freq[ch1-'a']--;
                if(freq[ch1-'a'] == 0) pq.poll();
                pq.offer(ch);
            }
        }

        return sb.toString();
    }
}
