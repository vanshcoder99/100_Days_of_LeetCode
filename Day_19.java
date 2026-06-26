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
