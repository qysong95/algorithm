/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode mid = findMiddle(head);
        ListNode one = head;
        ListNode two = reverse(mid.next);
        mid.next = null;
        ListNode dummyHead = new ListNode(0);
        while (one != null && two != null) {
            dummyHead.next = one;
            one = one.next;
            dummyHead.next.next = two;
            two = two.next;
            dummyHead = dummyHead.next.next;
        }
        if (one != null) {
            dummyHead.next = one;
        } else {
            dummyHead.next = two;
        }
    }
    
    private ListNode findMiddle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
