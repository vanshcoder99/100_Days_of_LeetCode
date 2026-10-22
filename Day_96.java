// 445. Add Two Numbers II
class Solution {
    public ListNode reverse(ListNode head){
        ListNode curr = head, prev = null;
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode prev1 = reverse(l1);
        ListNode prev2 = reverse(l2);
        ListNode temp1 = prev1 , temp2 = prev2,dummy = new ListNode(-1);
        ListNode temp = dummy;
        int carry = 0;
        while(temp1 != null || temp2 != null){
            if(temp1 != null){
                carry+=temp1.val;
                temp1 = temp1.next;
            }
            if(temp2 != null){
                carry+=temp2.val;
                temp2 = temp2.next;
            }
            temp.next = new ListNode(carry%10);
            carry = carry / 10;
            temp = temp.next;
        }
        if(carry != 0){
            temp.next = new ListNode(carry%10);
            temp = temp.next;
        }
        ListNode head = reverse(dummy.next);
        dummy.next = null;
        return head;
    }
}
