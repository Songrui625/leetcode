package 链表.lc86_分隔链表;

import 链表.ListNode;

public class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode p = dummy;

        while (p.next != null) {
            if (p.next.val < x) {
                p = p.next;
            } else {
                ListNode q = p.next;
                while (q.next != null) {
                    if (q.next.val < x) {
                        ListNode tmp = q.next;
                        q.next = tmp.next;
                        tmp.next = p.next;
                        p.next = tmp;
                        p = tmp;
                    } else {
                        q = q.next;
                    }
                }
            }
            break;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);


        Solution solution = new Solution();
        head = solution.partition(head, 3);
        ListNode.traverse(head);
    }
}
