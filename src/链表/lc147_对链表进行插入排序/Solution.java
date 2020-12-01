package 链表.lc147_对链表进行插入排序;

import 链表.ListNode;


/**
 * 解题思路：维护一个排列好的有序的链表，头为dummy, 尾部指针为tail
 * 检查每个结点的大小,1)如果大于或等于尾部结点的值,则把tail指针后移
 *                  2)如果小于尾部结点的值,则遍历有序链表,找到待插入结点的结点,插入,然后结束这趟遍历(break)
 *
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
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
}
