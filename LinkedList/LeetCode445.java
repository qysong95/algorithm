/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode one = reverse(l1);
        ListNode two = reverse(l2);
        ListNode res = add(one, two);
        return reverse(res);
    }
    
    private ListNode reverse(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
    
    private ListNode add(ListNode one, ListNode two) {
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        int sum = 0;
        while (one != null || two != null) {
            sum = sum / 10;
            if (one != null) {
                sum += one.val;
                one = one.next;
            }
            if (two != null) {
                sum += two.val;
                two = two.next;
            }
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
        }
        if (sum / 10 != 0) {
            cur.next = new ListNode(sum / 10);
        }
        return dummyHead.next;
    }
}
