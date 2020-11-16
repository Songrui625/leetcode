package 链表.lc206_反转链表;

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

/**
 * 迭代法：我们对当前节点与后一个结点交换。
 * 交换规则是：后一个结点必须要移动到链表头部，也就是后一个结点的next引用要指向head。
 * 所以要求每次迭代时都要更新head。
 */

public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode curNode = head;
        while(curNode.next != null) {
            ListNode tmp = curNode.next;
            curNode.next = tmp.next;
            tmp.next = head;
            head = tmp;
        }
        return head;
    }
}
