// 1019. Next Greater Node In Linked List
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode temp = head;
        int n = 0;
        while(temp != null){
            list.add(temp.val);
            n++;
            temp = temp.next;
        }
        int[] nge = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && list.get(i) >= st.peek()){
                st.pop();
            }
            nge[i] = st.isEmpty() ? 0 : st.peek();
            st.push(list.get(i));
        }
        return nge;

    }
}
