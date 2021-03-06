package 链表.lc206_反转链表;

import 链表.ListNode;

/**
 * 迭代法：我们对当前节点与后一个结点交换。
 * 交换规则是：后一个结点必须要移动到链表头部，也就是后一个结点的next引用要指向head。
 * 所以要求每次迭代时都要更新head。
 */

public class Solution {
//    public ListNode reverseList(ListNode head) {
//        if (head == null || head.next == null) return head;
//        ListNode curNode = head;
//        while(curNode.next != null) {
//            ListNode tmp = curNode.next;
//            curNode.next = tmp.next;
//            tmp.next = head;
//            head = tmp;
//        }
//        return head;
//    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode ret = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return ret;
    }

    public static void traverse(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        System.out.print("反转前：");
        traverse(head);
        head = reverseList(head);
        System.out.print("反转后：");
        traverse(head);
    }
}
