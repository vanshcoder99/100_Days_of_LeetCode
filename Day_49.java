// Top K Frequent Elements
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[k];
        Map<Integer,Integer> mpp = new HashMap<>();
        for(int i=0;i<n;i++){
            mpp.put(nums[i],mpp.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> Integer.compare(mpp.get(b),mpp.get(a)));
        for(var it : mpp.keySet()){
            pq.offer(it);
        }
        int i = 0;
        while(i<k && !pq.isEmpty()){
            ans[i] = pq.poll();
            i++;
        }
        
        return ans;
    }
}



// Kth Largest Element in an Array
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<k;i++){
            pq.offer(nums[i]);
        }
        for(int i=k;i<n;i++){
            int val = nums[i];
            if(val>pq.peek()){
                pq.poll();
                pq.offer(val);
            }
        }
        return pq.peek();
    }
}
