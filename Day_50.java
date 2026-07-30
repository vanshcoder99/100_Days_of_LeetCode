// Sort an Array
class Solution {
    public void heapifyDown(int[] nums, int ind, int last){
        int lchild = 2*ind+1, rchild = 2*ind+2, largest = ind;
        if(lchild<=last && nums[lchild]>nums[largest]) largest = lchild;
        if(rchild<=last && nums[rchild]>nums[largest]) largest = rchild;
        if(largest != ind){
            int temp = nums[ind];
            nums[ind] = nums[largest];
            nums[largest] = temp;
            heapifyDown(nums,largest,last);
        }
    }
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        for(int i=n/2 - 1; i>=0; i--){
            heapifyDown(nums,i,n-1);
        }

        int last = n - 1;
        while(last > 0){
            int temp = nums[last];
            nums[last] = nums[0];
            nums[0] = temp;
            last--;
            if(last>0){
                heapifyDown(nums,0,last);
            }
        }
        return nums;
    }
}



// Sort Characters By Frequency
class Solution {
    public String frequencySort(String s) {
        int n = s.length();
        Map<Character,Integer> mpp = new HashMap<>();
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            mpp.put(ch,mpp.getOrDefault(ch,0)+1);
        }
        PriorityQueue<Character> pq = new PriorityQueue<>((a,b) -> Integer.compare(mpp.get(b), mpp.get(a)));
        for(var it : mpp.keySet()){
            pq.offer(it);
        } 
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            char ch = pq.poll();
            int freq = mpp.get(ch);
            while(freq != 0){
                sb.append(ch);
                freq--;
            }
        }
        return sb.toString();
    }
}
