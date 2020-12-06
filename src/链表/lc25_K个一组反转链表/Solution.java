package 链表.lc25_K个一组反转链表;

import 链表.ListNode;

/**
 * 解题思路：两趟遍历
 * 辅助函数 ListNode traverse(ListNode head, int m)
 * 返回值：返回反转了前m个结点的链表头结点
 * 由于小于k个结点的剩余结点保持不变，所以首先要遍历一次计算链表长度len
 * len/k 就是要反转的趟数
 *
 * 哑结点dummy用于辅助反转，
 * prev结点连接每次反转m个结点的链表头结点,连接后往后移动k个结点。
 *
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k <= 1) return head;

        int size = 0;
        ListNode p = head;
        while (p != null) {
            p = p.next;
            size++;
        }
        int step = size / k;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        int count = 0;
        ListNode prev = dummy;
        while (prev.next != null && step-- > 0) {
            prev.next = reverse(prev.next, k);
            if (prev.next == null) break;
            for (count = 0; count < k; count++) {
                if (prev.next != null)
                    prev = prev.next;
            }
        }
        return dummy.next;
    }

    public ListNode reverse(ListNode head, int m) {
        if (head == null || head.next == null) return head;
        ListNode p = head;
        while (p.next != null && --m > 0) {
            ListNode tmp = p.next;
            p.next = tmp.next;
            tmp.next = head;
            head = tmp;
        }

        return head;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);



        Solution solution = new Solution();
        head = solution.reverseKGroup(head, 3);
//        head = solution.reverseKGroup(head, 3);

        ListNode.traverse(head);
    }
}