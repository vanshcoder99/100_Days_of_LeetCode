// Count Inversions --> GFG
class Solution {
    public long merge(int low,int mid, int high,int[] nums,long[] cnt){
        int left = low, right = mid + 1;
        List<Integer> temp = new ArrayList<>();
        while(left<=mid && right<=high){
            if(nums[left] > nums[right]){
                cnt[0]+=(mid-left+1);
                temp.add(nums[right++]);
            }
            else{
                temp.add(nums[left++]);
            }
        }
        while(left<=mid){
            temp.add(nums[left++]);
        }
        while(right<=high){
            temp.add(nums[right++]);
        }
        for(int i=low;i<=high;i++){
            nums[i] = temp.get(i-low);
        }
        return cnt[0];
    }
    public long mergesort(int low, int high,int[] nums,long[] cnt){
        if(low>=high) return 0;
        int mid = low - ((low-high)/2);
        mergesort(low,mid,nums,cnt);
        mergesort(mid+1,high,nums,cnt);
        merge(low,mid,high,nums,cnt);
        return cnt[0];
    }
    public long numberOfInversions(int[] nums) {
        int n = nums.length;
        if(n<=1) return 0;
        long[] cnt = new long[1];
        mergesort(0,n-1,nums,cnt);
        return cnt[0];
    }
}


//  Remove Nth Node From End of List
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        while(n!=0){
            if(fast == null) return head;
            fast = fast.next;
            n--;
        }
        if(fast == null) return head.next;
        ListNode slow = head;
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
