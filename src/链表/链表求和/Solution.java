package 链表.链表求和;

import 链表.ListNode;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null)
            return l1 == null? l2 : l1;

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        int carry = 0;
        while (l1 != null || l2 != null || carry > 0) {
            int sum = 0;
            sum += (l1 == null ? 0 : l1.val);
            sum += (l2 == null ? 0 : l2.val);
            sum += carry; //一定要加上进位后再对10取余
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
            carry = sum / 10;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(5);

        Solution solution = new Solution();
        ListNode ret = solution.addTwoNumbers(l1, l2);
        System.out.println(ret.val);
    }
}
