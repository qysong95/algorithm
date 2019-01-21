/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        ListNode smallHead = new ListNode(0);
        ListNode smallCur = smallHead;
        ListNode largeHead = new ListNode(0);
        ListNode largeCur = largeHead;
        while (head != null) {
            if (head.val < x) {
                smallCur.next = head;
                smallCur = smallCur.next;
            } else {
                largeCur.next = head;
                largeCur = largeCur.next;
            }
            head = head.next;
        }
        smallCur.next = largeHead.next;
        largeCur.next = null;
        return smallHead.next;
    }
}
