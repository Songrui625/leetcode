package 链表.回文链表;

import 链表.ListNode;

public class Solution {
    ListNode temp;

    public boolean isPalindrome(ListNode head) {
        temp = head;
        return check(head);
    }

    private boolean check(ListNode head) {
        if (head == null)
            return true;
        boolean res = check(head.next) && (temp.val == head.val);
        temp = temp.next;
        return res;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(head));
    }
}
