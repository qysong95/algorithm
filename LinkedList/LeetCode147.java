/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        while (head != null) {
            ListNode prev = dummyHead;
            ListNode cur = dummyHead.next;
            while (cur != null && cur.val < head.val) {
                prev = cur;
                cur = cur.next;
            }
            prev.next = head;
            head = head.next;
            prev.next.next = cur;
        }
        return dummyHead.next;
    }
}
