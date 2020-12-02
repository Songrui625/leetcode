package 链表.lc148_排序链表;

import 链表.ListNode;

public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;

        head = dummy;
        ListNode tail = dummy;

        while (head.next != null) {
            if (head.next.val < tail.val) {
                ListNode p = dummy;
                ListNode toInsert = head.next;
                head.next = toInsert.next;
                while (p.next != null && p != tail) {
                    if (p.next.val < toInsert.val) {
                        p = p.next;
                    } else {
                        toInsert.next = p.next;
                        p.next = toInsert;
                        break;
                    }
                }
            } else {
                head = head.next;
                tail = tail.next;
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {

    }
}
