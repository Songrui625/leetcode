package 链表.lc445_两数相加;


import 链表.ListNode;

import java.util.Stack;

/**
 * 思路一：利用栈
 * 由于，最高位位于链表头，所以要把两个链表结点入栈。
 * 循环的时候需要考虑进位的问题。
 * 1、如果有进位的话，那么新节点的值等于两个栈取出来的值需要加上进位。进位的判别就是carry = sum / 10(或者是 sum >= 10 ? 1 : 0);
 *    但是这是最后才赋值的，因为这是为下一次辅助的。
 * 2、循环判断条件需要注意的就是进位，最后的情况就是carry > 0 （其实是考虑最后一次）
 * 3、
 */

public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null)
            return l1 == null ? l2 : l1;

        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        ListNode head = null;
        while (!s1.isEmpty() || !s2.isEmpty() || carry > 0) {
            int val1 = s1.isEmpty() ? 0 : s1.pop();
            int val2 = s2.isEmpty() ? 0 : s2.pop();
            int sum = val1 + val2 + carry;
            int nodeVal = sum % 10;
            ListNode node = new ListNode(nodeVal);
            node.next = head;
            head = node;
            carry = sum >= 10 ? 1 : 0;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        Solution solution = new Solution();
        ListNode head = solution.addTwoNumbers(l1, l2);
        ListNode.traverse(head);
    }
}
