package 链表.lc92_反转链表II;

import 链表.ListNode;

public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int count = n - m;

        ListNode p = dummy;
        //定位到要反转结点的前驱节点
        while (--m > 0) p = p.next;

        ListNode subHead = p.next;
        ListNode prev = p;
        p = p.next;

        //count躺反转
        while (p.next != null && count-- > 0) {
            ListNode tmp = p.next;
            p.next = tmp.next;
            tmp.next = subHead;
            subHead = tmp;
        }

        //连接反转后的头。
        prev.next = subHead;

        return dummy.next;
    }

//    public ListNode reverseBetween(ListNode head, int m, int n) {
//        if (head == null || head.next == null) return head;
//
//        ListNode dummy = new ListNode(0);
//        dummy.next = head;
//        ListNode p = dummy;
//
//        while (--m > 0) p = p.next;
//
//
//    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        Solution solution = new Solution();
        head = solution.reverseBetween(head, 2, 4);

        ListNode.traverse(head);
    }

}
