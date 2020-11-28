package 链表.删除指定节点;

import 链表.ListNode;

public class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        head = dummy;

        while (head.next != null) {
            if (head.next.val == val) {
                head.next = head.next.next;
                return dummy.next;
            }
            head = head.next;
        }
        return dummy.next;
    }
}
