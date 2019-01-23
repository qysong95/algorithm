public ListNode mergeSort(ListNode head) {
    if (head == null) {
        return head;
    }
    ListNode mid = findMiddle(head);
    ListNode right = mid.next;
    mid.next = null;
    ListNode one = mergeSort(head);
    ListNode two = mergeSort(right);
    return merge(one, two);
}

private ListNode findMiddle(ListNode head) {
    ListNode fast = head;
    ListNode slow = head;
    while (fast.next != null && fast.next.next != null) {
        fast = fast.next.next;
        slow = slow.next;
    }
    return slow;
}

private ListNode merge(ListNode one, ListNode two) {
    ListNode dummyHead = new ListNode(0);
    ListNode cur = dummyHead;
    while (one != null && two != null) {
        if (one.value <= two.value) {
            cur.next = one;
            one = one.next;
        } else {
            cur.next = two;
            two = two.next;
        }
        cur = cur.next;
    }
    // post processing
    if (one != null) {
        cur.next = one;
    } else {
        cur.next = two;
    }
    return dummyHead.next;
}
