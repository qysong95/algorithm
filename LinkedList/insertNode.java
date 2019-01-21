public ListNode insert(ListNode head, int x) {
    ListNode node = new ListNode(x);
    if (head == null || head.value > x) {
        node.next = head;
        return node;
    }
    ListNode cur = head;
    while (cur.next != null && cur.next.value < x) {
        cur = cur.next;
    }
    node.next = cur.next;
    cur.next = node;
    return head;
}
