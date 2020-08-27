package 链表.lc61_旋转链表;

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

/**
 * 主要思路：根据数学关系，在长度为n的链表向移动k个位置形成新链表。
 * 新链表的头节点是第n - k%n个，尾结点是第 n - k - 1个。
 * 只需要找到新的尾结点以及设置新的头结点，然后让原链表的尾结点指向头结点即可。
 * 边界情况：①如果链表为空或者只有一个结点，无论移动多少次结果都是一样的
 *          ②如果第实际要移动的长度 k % n 为0时，不用移动链表。
 */

public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = head;
        int len = 0;
        while (p != null) {
            p = p.next;
            len++;
        }
        int step = k % len;
        if (step == 0) {
            return head;
        }
        p = head;
        for (int i = 0; i < len - step - 1; i++) {
            p = p.next;
        }
        ListNode newHead = p.next;
        p.next = null;
        p = newHead;
        while (p.next != null) {
            p = p.next;
        }
        p.next = head;
        return newHead;
    }

}
