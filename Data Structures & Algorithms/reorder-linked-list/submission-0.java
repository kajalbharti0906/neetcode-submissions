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
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        while(curr!=null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public void reorderList(ListNode head) {
        // 0,1,2,3,4,5,6
        // 0,6,5,4,3,2,1
        // 0,6,1,2,3,4,5
        // 0,6,1,5,4,3,2
        // 0,6,1,5,2,3,4
        // 0,6,1,5,2,4,3
        ListNode curr = head;
        while(curr!=null) {
            ListNode next = reverseList(curr.next);
            curr.next = next;
            curr = next;
        }
    }
}
