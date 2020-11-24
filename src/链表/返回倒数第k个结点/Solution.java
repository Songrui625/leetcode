package 链表.返回倒数第k个结点;

import 链表.ListNode;

public class Solution {

    public int kthToLast(ListNode head, int k) {
        if (head == null ) return 0;

        ListNode p = head;
        int len = 0;
        while (p != null) {
            len++;
            p = p.next;
        }

        p = head;
        for (int i = 0; i < len - k; i++)
            p = p.next;

        return p.val;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);



        Solution solution = new Solution();
        int val = solution.kthToLast(head, 2);
        System.out.println(val);
    }
}
