// Add Two Numbers
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        int carry = 0;
        while(l1 != null || l2 != null){
            int sum = carry;
            if(l1 != null){
                sum+=l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                sum+=l2.val;
                l2 = l2.next;
            }
            curr.next = new ListNode(sum%10);
            curr = curr.next;
            carry = sum/10;
        }
        if(carry != 0){
            curr.next = new ListNode(carry);
        }
        return dummy.next;
    }
}



// Merge Two Sorted Lists
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while(list1 != null && list2 != null){
            if(list1.val >= list2.val){
                curr.next = list2;
                curr = curr.next;
                list2 = list2.next;
            }
            else{
                curr.next = list1;
                curr = curr.next;
                list1 = list1.next;
            }
        }
        if(list1 != null){
            curr.next =  list1;
        }
        else{
            curr.next = list2;
        }
        return dummy.next;
    }
}



// Palindrome Linked List
class Solution {
    public ListNode middle(ListNode head){
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public ListNode reverseLL(ListNode head){
        ListNode curr = head, prev = null;
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode mid = middle(head);
        ListNode t2 = reverseLL(mid.next);
        mid.next = null;
        ListNode t1 = head;
        while(t1 != null && t2 != null){
            if(t1.val != t2.val) return false;
            t1 = t1.next;
            t2 = t2.next;
        }
        return true;
    }
}



// Rotate List
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) return head;
        ListNode tail = head;
        int n = 1;
        while(tail.next != null){
            tail = tail.next;
            n++;
        }       
        k = k % n;
        if(k == 0) return head;
        int s = n - k - 1;
        ListNode temp = head;
        while(s != 0){
            temp = temp.next;
            s--;
        } 
        ListNode newhead = temp.next;
        temp.next = null;
        tail.next = head;
        return newhead;
    }
}



// Max Consecutive Ones
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int mcnt = 0, cnt = 0;
        for(int i=0;i<n;i++){
            if(nums[i] == 1){
                cnt++;
                mcnt = Math.max(mcnt,cnt);
            }
            else{
                cnt = 0;
            }
        }
        return mcnt;
    }
}
