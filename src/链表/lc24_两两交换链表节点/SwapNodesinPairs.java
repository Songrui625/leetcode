package 链表.lc24_两两交换链表节点;

import 链表.ListNode;

public class SwapNodesinPairs {
//    public ListNode swapPairs(ListNode head) {
//
//    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode newNode = new ListNode(2);
        head.next = newNode;

        head.next.next = head;
        head.next = null;


        while (head != null) {
            System.out.print(head.val);
            System.out.print('\t');
            head = head.next;
        }
    }
}
